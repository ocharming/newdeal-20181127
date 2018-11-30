package com.eomcs.util;

public class Stack<E> extends LinkedList<E> implements Cloneable {

  private int maxSize;
  
  public Stack() {
    maxSize = 100;
  }
  
  public Stack(int maxSize) {
    this.maxSize = maxSize;
  }
  
  @Override
  public Stack<E> clone() {
    Stack<E> temp = new Stack<>();
    for (int i = 0; i < size(); i++) {
      temp.add(get(i));
    }
    return (Stack<E>) temp;
  }
  
  public void push(E value) {
    if (size() == maxSize)
      remove(0);
    add(value);
  }
  
  public E pop() {
    return remove(size() - 1);
  }
  
  public Iterator<E> iterator() {
    
    return new IteratorImpl<>();
    
  }
  
  // inner class (중첩클래스 장점: 바깥 클래스에 마음대로 접근할수잇다. 찾아갈 필요가 없이 직관적으로 볼 수 있다.
  // 한번만 쓸 클래스는 쓸데없이 바깥에 정의 할 필요가 없다.) 
  class IteratorImpl<T> implements Iterator<T>{

    Stack<?> stack;
    int count;
    
    {  //인스턴스 블록 인스턴스가 실행될때마다 실행 된다. 생성자보다 먼저 실행된다.  
      this.stack = Stack.this.clone();
    }
    
    @Override
    public boolean hasNext() {
      return this.count < Stack.this.size();
    }

    @Override
    public T next() {
      this.count++;
      return (T)stack.pop();
    }
    
  }
  
  
  /*
  public static void main(String[] args) throws Exception {
    Stack<String> stack = new Stack<>();
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    stack.push("ddd");
    stack.push("eee");
    stack.push("fff");
    
    Stack<String> temp1 = stack.clone();
    while (temp1.size() > 0) {
      System.out.println(temp1.pop());
    }
    System.out.println("----------------------");
    
    Stack<String> temp2 = stack.clone();
    while (temp2.size() > 0) {
      System.out.println(temp2.pop());
    }
  }*/
}
