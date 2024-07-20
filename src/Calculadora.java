public class Calculadora {

	public Operacoes calcular(Operacoes operacao) {
		switch (operacao.getOperador()) {
		case '+':
			operacao.setResultado(soma(operacao));
			break;
		case '-':
			operacao.setResultado(subtracao(operacao));
			break;
		case '*':
			operacao.setResultado(multiplicacao(operacao));
			break;
		case '/':
			operacao.setResultado(divisao(operacao));
			break;
		default:
			operacao.setResultado(0);
			break;
		}
		return operacao;
	}

	public long soma(Operacoes operacao) {
		return (long) operacao.getValorA() + operacao.getValorB();
	}

	public long subtracao(Operacoes operacao) {
		return (long) operacao.getValorA() - operacao.getValorB();
	}

	public long multiplicacao(Operacoes operacao) {
		return (long) operacao.getValorA() * operacao.getValorB();
	}

	public double divisao(Operacoes operacao) {
		if (operacao.getValorB() != 0) {
			return (double) operacao.getValorA() / operacao.getValorB();
		} else {
			System.out.println("Erro de divisão por zero!");
			return 0;
		}
	}
}