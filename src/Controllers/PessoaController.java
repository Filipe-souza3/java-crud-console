package Controllers;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.PessoaDAO;
import Models.Pessoa;

public class PessoaController {

//	Scanner scanner = new Scanner(System.in);
	PessoaDAO pessoadao = new PessoaDAO();

	public void Insert(Scanner scanner) throws Exception {
		Pessoa pessoa = new Pessoa();
		System.out.print("Digite o nome: ");
		pessoa.setNome(scanner.next());
		System.out.print("Digite o email: ");
		pessoa.setEmail(scanner.next());
		pessoadao.Insert(pessoa);
		System.out.print("inserido");
	}
	
	public void List() throws Exception {
		java.util.List<Pessoa> pessoas = new ArrayList();
		System.out.print("lista de pessoas\n");
		pessoas = pessoadao.list();
		pessoas.forEach(p->System.out.print(
				"ID: "+p.getId()+
				"\nNome: "+p.getNome()+
				"\nEmail: "+p.getEmail()+
				"\n===============================\n"));
	}
	
	public void Delete(Scanner scanner) throws Exception {
		System.out.print("Digite o id da pessoa a ser excluida:");
		int idPessoa = scanner.nextInt();
		pessoadao.Delete(idPessoa);
		System.out.println("excluido");
	}
	
	public void Edit(Scanner scanner) throws Exception {
		System.out.println("Editar");
		Pessoa pessoa = new Pessoa();
		System.out.print("Digite o id da pessoa a ser editada:");
		pessoa.setId(scanner.nextInt());
		System.out.println("Editando");
		System.out.print("Digite o novo nome:");
		pessoa.setNome(scanner.next());
		System.out.print("Digite o novo email:");
		pessoa.setEmail(scanner.next());
		pessoadao.Edit(pessoa);
		System.out.println("Editado");
	}
	
}
