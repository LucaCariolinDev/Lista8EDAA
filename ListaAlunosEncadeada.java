import java.io.*;

public class ListaAlunosEncadeada {

  Node head;

  static class Node {

    Aluno data;
    Node next;

    // Constructor
    Node(Aluno d) {
      data = d;
      next = null;
    }
  }

  public static ListaAlunosEncadeada inserirAluno(ListaAlunosEncadeada list,
    Aluno data) {

    Node new_node = new Node(data);
    new_node.next = null;

    if (list.head == null) {
      list.head = new_node;
    } else {
      Node last = list.head;
      while (last.next != null) {
        last = last.next;
      }
      last.next = new_node;
    }

    return list;
  }

  public static void imprimirLista(ListaAlunosEncadeada list) {
    Node currNode = list.head;
    while (currNode != null) {
      System.out.println(currNode.data.toString() + " ");

      currNode = currNode.next;
    }
  }
  
  public static int quantidadeAlunos(ListaAlunosEncadeada list) {
	    Node currNode = list.head;
	    int cont = 0;

	    while (currNode != null) {
	      cont++;
	      currNode = currNode.next;
	    }
	    
	    return cont;
  }

  public static ListaAlunosEncadeada excluirPorMatricula(ListaAlunosEncadeada list,
    int key) {

    Node currNode = list.head, prev = null;

    if (currNode != null && currNode.data.getMatricula() == key) {
      list.head = currNode.next;

      System.out.println(key + " removido");

      return list;
    }

    while (currNode != null && currNode.data.getMatricula() != key) {
      prev = currNode;
      currNode = currNode.next;
    }

    if (currNode != null) {
      prev.next = currNode.next;

      System.out.println(key + " removido");
    }

    if (currNode == null) {
      System.out.println(key + " não encontrado");
    }

    return list;
  }

  public static void inserirAlunoPrimeiraPosicao(ListaAlunosEncadeada list, Aluno val) {
    Node n = new Node(val);
    n.next = list.head;
    list.head = n;
  }

  public static void inserirAlunoEmPosicao(ListaAlunosEncadeada list, int key, Aluno val) {
    Node n = new Node(val);
    if (key == list.head.data.getMatricula()) {
      n.next = list.head.next;
      list.head.next = n;
      return;
    }
    Node temp = list.head;
    while (temp.data.getMatricula() != key) {
      temp = temp.next;
      if (temp == null) {
        return;
      }
    }
    n.next = temp.next;
    temp.next = n;
  }

  public static void inserirAlunoUltimaPosicao(ListaAlunosEncadeada list, Aluno val) {
    Node n = new Node(val);
    if (list.head == null) {
      list.head = n;
      return;
    }
    Node temp = list.head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = n;
  }
}