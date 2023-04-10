
/**
 * MIT License
 *
 * Copyright(c) 2021-23 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * Classe básica para um Grafo simples não direcionado.
 */
public abstract class Grafo {
	private final String nome;
	protected ABB<Vertice> vertices;

	/**
	 * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso
	 * de nome não informado (string vazia), recebe o nome genérico "Grafo"
	 */
	public Grafo(String nome) {
		if (nome.length() == 0)
			this.nome = "Grafo";
		else
			this.nome = nome;
		this.vertices = new ABB<>();
	}

	public static Grafo grafoCompleto(int ordem) {
		return new GrafoCompleto(ordem);
	}

	/**
	 * Retorna o nome do grafo (string), caso seja necessário em outras
	 * classes/sistemas
	 *
	 * @return O nome do grafo (uma string)
	 */
	public String nome() {
		return this.nome;
	}

	/**
	 * Retorna existencia do vertice
	 *
	 * @param id
	 * @return vertice
	 */
	public Vertice existeVertice(int idVertice) {
		return vertices.find(idVertice);
	}

	/**
	 * Retorna existencia da Aresta
	 *
	 * @param IdVerticeA
	 * @param IdVerticeB
	 * @return aresta
	 */
	public Aresta existeAresta(int origin, int destiny) {

		Vertice og = vertices.find(origin);

		return og.existeAresta(destiny);
	}

	/**
	 * Retorna um boolean para grafo completo
	 *
	 * @return boolean
	 */
	public boolean completo() {
		boolean res = true;

		Vertice[] allVertices = listaVertices();

		for (Vertice vertice : allVertices) {
			if ((vertice.grau() != (ordem() - 1))) {
				res = false;
			}

		}

		return res;
	}

	/**
	 * Retorna um subgrafo
	 *
	 * @param ListaDeVertices
	 * @return subgrafo
	 */
<<<<<<< HEAD
	public Grafo subGrafo(Lista<Integer> vertices) throws InvalidParameterException {
		// FALTA TERMINAR!!!!!!
		Vertice[] listaVertices = listaVertices();
		Lista<Integer> listaQualquer = new Lista<>();
		Grafo sub = new GrafoNaoDirecionado("subgrafo");
		for (int i = 0; i < vertices.size(); i++) {
			for (Vertice cadaVertice : listaVertices) {
				if (true) { // comparar a lista do subgrafo com o grafo original
					// se existir, entao adicionar a posicao no subgrafo
					// Vertice v = new vertice(cadaVertice.getID())
					// g.add(v.getId())
=======
	// public Grafo subGrafo(Lista<Integer> vertices) throws
	// InvalidParameterException {
	// Grafo subgrafo = new Grafo("Subgrafo de " + this.nome);

	// Vertice[] listaVertices = listaVertices();
	// for (Integer i : vertices.allElements(null)) {
	// if (this.existeVertice(i) == null) {
	// throw new InvalidParameterException("Um vertice não pertence ao Grafo
	// original");
	// }
	// subgrafo.addVertice(i);
	// }

	// for (Vertice v : listaVertices) {
	// for (Aresta a : v.listaArestas()) {
	// if (this.existeVertice(a.destino()) != null) {
	// subgrafo.addAresta(v.getId(), a.destino());
	// }
	// }
	// }

	// return subgrafo;
	// }

	public int tamanho() {

		int totalArestas = 0;

		Vertice[] allVertice = listaVertices();

		// limpando todas as visitas de todas as arestas
		for (Vertice vertice : allVertice) {
			Aresta[] listaArestas = vertice.listaArestas();
			for (Aresta aresta : listaArestas) {
				aresta.limparVisita();
			}
		}

		// Passeando por todas as aresas
		for (Vertice vertice : allVertice) {
			Aresta[] listaArestas = vertice.listaArestas();
			for (Aresta aresta : listaArestas) {
				if (!aresta.visitada()) {
					totalArestas++;
					aresta.visitar();
					// verificando se existe uma aresta duplicada, se existe, marco como visitada.
					Aresta arestaDestino = vertices.find(aresta.destino()).existeAresta(vertice.getId());
					if (arestaDestino != null) {
						arestaDestino.visitar();
					}
>>>>>>> fff88e3c70e68fa4be15f2ecb2da32fabbc9ff24
				}
			}
		}

<<<<<<< HEAD
		/*
		 * 1. criar um subgrafo
		 * 2. verificar se todos vertices estao na lista de vertices e inserir no
		 * subgrafo
		 * 3. no meu subgrafo dou um new Vertice de todos os vertices e dps um add
		 * 4. para cada vertice do subgrafo verificar se o vertice destino existe no
		 * subgrafo e ligar com uma aresta
		 * 5. return subgrafo
		 */
		return null;
	}

	public int tamanho() {
		return Integer.MIN_VALUE;
=======
		// resetando as visitas para não atrapalhar as buscas.
		for (Vertice vertice : allVertice) {
			Aresta[] listaArestas = vertice.listaArestas();
			for (Aresta aresta : listaArestas) {
				aresta.limparVisita();
			}
		}

		return totalArestas + vertices.size();
>>>>>>> fff88e3c70e68fa4be15f2ecb2da32fabbc9ff24
	}

	/**
	 * Método que retornar a ordem do grafo.
	 * 
	 * @return int com a quantidade de vértices do grafo.
	 */
	public int ordem() {
		return vertices.size();
	}

	public Grafo bfs(int idVerticeInicio) {
		return null;
	}

	public Grafo dfs(int idVerticeInicio) {
		return null;
	}

	protected Vertice[] listaVertices() {
		Vertice[] listaVertices = new Vertice[vertices.size()];
		vertices.allElements(listaVertices);
		return listaVertices;
	}

}
