import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Program {

	public static void main(String[] args) {
		Queue<Operacoes> filaOperacoes = new LinkedList<>();
		filaOperacoes.add(new Operacoes() {
			{
				setValorA(2);
				setValorB(3);
				setOperador('+');
			}
		});
		filaOperacoes.add(new Operacoes() {
			{
				setValorA(14);
				setValorB(8);
				setOperador('-');
			}
		});
		filaOperacoes.add(new Operacoes() {
			{
				setValorA(5);
				setValorB(6);
				setOperador('*');
			}
		});
		filaOperacoes.add(new Operacoes() {
			{
				setValorA(2147483647);
				setValorB(2);
				setOperador('+');
			}
		});
		filaOperacoes.add(new Operacoes() {
			{
				setValorA(18);
				setValorB(3);
				setOperador('/');
			}
		}); 

		Calculadora calculadora = new Calculadora();
		Stack<Operacoes> resultados = new Stack<>();
		DecimalFormat df = new DecimalFormat("0");

		while (!filaOperacoes.isEmpty()) {
			Operacoes operacao = filaOperacoes.poll();
			calculadora.calcular(operacao);

			System.out.print("Operação Atual: ");
			System.out.printf("%d %c %d = %s%n", operacao.getValorA(), operacao.getOperador(), operacao.getValorB(),
					df.format(operacao.getResultado()));
			resultados.push(operacao);

			System.out.println("Próximas Operações:");
			for (Operacoes op : filaOperacoes) {
				System.out.printf("%d %c %d%n", op.getValorA(), op.getOperador(), op.getValorB());
			}
			System.out.println("------------------\n");
		}

		System.out.println("Resultados das Operações:");
		Stack<Operacoes> resultadosImpressos = (Stack<Operacoes>) resultados.clone();
		while (!resultadosImpressos.isEmpty()) {
			Operacoes resultado = resultadosImpressos.pop();
			System.out.printf("%d %c %d = %s%n", resultado.getValorA(), resultado.getOperador(), resultado.getValorB(),
					df.format(resultado.getResultado()));
		}
	}
}