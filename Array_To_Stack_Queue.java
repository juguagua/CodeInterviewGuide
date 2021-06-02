package Basics;

public class Array_To_Stack_Queue {
  public static class ArrayStack{
      private Integer[] arr;
      private Integer size;

      public ArrayStack(int initSize){
          if (initSize < 0){
              throw new IllegalArgumentException("The initSize is less than 0");

          }
          arr = new Integer[initSize];
          size = 0;

      }
      public Integer peek(){
          if (size == 0){
              return null;

          }
          return arr[size - 1];
      }
      public void push(int obj){
        if (size == arr.length){
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        arr[size++] = obj;   // size指示的位置始终为空
      }
      public Integer pop(){
          if (size == 0){
              throw new ArrayIndexOutOfBoundsException("The queue is empty");
          }
          return arr[--size];
      }


  }
  public class ArrayQueue{
      private Integer[] arr;
      private Integer size;
      private Integer first;
      private Integer last;

      public ArrayQueue(int initSize){
          if (initSize < 0 ){
              throw new IllegalArgumentException("The initSize is less than 0");
          }
          arr = new Integer[initSize];
          size = 0;
          first = 0;
          last = 0;
      }
      public Integer peek(){
          if (size == 0){
              return null;
          }
          return arr[first];
      }
      public void push(int obj){
          if (size == arr.length){
              throw new ArrayIndexOutOfBoundsException("The queue is full");
          }
          size++;
          last = last == arr.length - 1 ? 0 : last + 1;
      }
      public int pop(){
          if (size == 0){
              throw new ArrayIndexOutOfBoundsException("The queue is empty");
          }
          size--;
          int temp = first;
          first = first == arr.length - 1 ? 0 : first + 1;
          return arr[temp];
      }
  }

    public static void main(String[] args) {

    }

}
