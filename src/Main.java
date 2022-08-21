import java.util.Scanner;

import Controllers.PessoaController;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner scanner = new Scanner(System.in);
		PessoaController pessoaController = new PessoaController();
		String arg[] = null;
		
		System.out.println("\n1 - LISTAR \n2 - INSERIR \n3 - EDITAR \n4 - EXCLUIR");
		System.out.print("Escolha uma opção: ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			pessoaController.List();
			main(arg);
			break;
		case 2:
			pessoaController.Insert(scanner);
			main(arg);
			break;
		case 3:
			pessoaController.Edit(scanner);
			main(arg);
			break;
		case 4:
			pessoaController.Delete(scanner);
			main(arg);
			break;
		default:
			System.out.println("OPÇÃO INVALIDA.");
			main(arg);
			break;
		}
		
	}
}
