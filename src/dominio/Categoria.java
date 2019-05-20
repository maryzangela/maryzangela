package dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	
	public Categoria(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
	}
	

	public Categoria() {
		
	}
	
	public void cadastrarCategoria(EntityManager entityManager) {
		Scanner c = new Scanner(System.in);
		//  categoria nova 
		System.out.println("Digite a categoria do produto: ");
		String nome= c.next();
		System.out.println("Digite a descrição do produto: ");
		String descricao = c.next();
		Categoria categoria = new Categoria(null, nome, descricao);
		System.out.println("Cadastro efetuado!");
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		}
	public void listarCategoria(EntityManager entityManager) {
		String jpql = "SELECT c FROM Categoria c";
		List <Categoria> categorias = entityManager.createQuery(jpql, Categoria.class).getResultList();
		System.out.println(categorias);
		
	}
	public void atualizarCategoria(EntityManager entityManager) {
		Scanner a = new Scanner(System.in);
		System.out.println("digite o id: ");
		Integer id = a.nextInt();
		Categoria categoriaFound = entityManager.find(Categoria.class, id);
		System.out.println("digite o novo nome: ");
		String nome = a.next();
		categoriaFound.setNome(nome);
		System.out.println("digite a nova descrição: ");
		String descricao = a.next();
		categoriaFound.setDescricao(descricao);
		entityManager.getTransaction().begin();
		entityManager.persist(categoriaFound);
		entityManager.getTransaction().commit();
		
	}
	public void removerCategoria(EntityManager entityManager) {
		Scanner r =  new Scanner(System.in);
		System.out.println("Digite o Id: ");
		Integer id = r.nextInt();
		Categoria rFound = entityManager.find(Categoria.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(rFound);
		entityManager.getTransaction().commit();
	
	}
	
	public void sair(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
		entityManagerFactory.close();
		entityManager.close();
	}
	
	
}
