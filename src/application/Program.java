package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Qual o número de contribuintes? ");
		int numero = sc.nextInt();
		sc.nextLine();
		
		String nome;
		double rendaAnual,gastosSaude;
		int numeroFuncionarios;
		
		List<Pessoa> lista = new ArrayList<>();
		
		for (int i=1;i<=numero;i++) {
			System.out.println("Contribuinte Nº" + i + ":");
			System.out.print("Pessoa física ou jurídica (F/J)? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			
			switch(type) {
			case 'F':
			System.out.print("Nome: ");
			nome = sc.nextLine();
			System.out.print("Renda anual: ");
			rendaAnual = sc.nextDouble();
			System.out.print("Gastos com saúde: ");
			gastosSaude = sc.nextDouble();
			Pessoa pessoaFisica = new PessoaFisica(nome,rendaAnual,gastosSaude);
			lista.add(pessoaFisica);
			break;
			case 'J':
			System.out.print("Nome: ");
			nome = sc.nextLine();
			System.out.print("Renda anual: ");
			rendaAnual = sc.nextDouble();
			System.out.print("Número de funcionários: ");
			numeroFuncionarios = sc.nextInt();
			Pessoa pessoaJuridica = new PessoaJuridica(nome,rendaAnual,numeroFuncionarios);
				lista.add(pessoaJuridica);
			break;
			}
			
		}
		double soma = 0;
		
		for (Pessoa l : lista) {
			System.out.println(l.getNome() + " " + l.calculoImposto());
			soma += l.calculoImposto();
		}
		
		System.out.println();
		System.out.println(soma);
		
		sc.close();
		
	}

}
