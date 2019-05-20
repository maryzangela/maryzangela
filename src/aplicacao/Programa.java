package aplicacao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Categoria;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prova-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Categoria c = new Categoria();
		
		Scanner entrada = new Scanner(System.in);
		
		int opcao;

		do {
			System.out.println("Digite 1: Para inserir uma nova Categoria");
			System.out.println("Digite 2: Para listar as categorias");
			System.out.println("Digite 3: Para alterar uma categoria");
			System.out.println("Digite 4: Para remover uma categoria");
			System.out.println("Digite 5: Para sair");
			opcao = entrada.nextInt();
			switch (opcao) {
			case 1:
				c.cadastrarCategoria(entityManager);
				break;
			case 2:
				c.listarCategoria(entityManager);
				break;		
			case 3:
				c.atualizarCategoria(entityManager);
				break;
			case 4: 
				c.removerCategoria(entityManager);
				break;
			case 5:
			c.sair(entityManager, entityManagerFactory);
		}
		}while(opcao != 0);
		
	


}
	
}