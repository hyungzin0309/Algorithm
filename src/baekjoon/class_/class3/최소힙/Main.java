package baekjoon.class_.class3.최소힙;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        MinHeap heap = new MinHeap(100000);
        for(int i = 0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            if(k == 0) bw.write(heap.remove()+"\n");
            else heap.add(k);
        }
        bw.flush();
    }

    static class MinHeap{

        int[] arr;
        int size = 0;

        public MinHeap(int capacity){
            arr = new int[capacity];
        }

        public void add(int num){
            size++;
            arr[size-1] = num;
            compareWithParentAndSwap(size-1);
        }

        public int remove(){
            if(size == 0) return 0;

            int returnValue = arr[0];
            arr[0] = arr[size-1];
            arr[size-1] = 0;
            size--;
            compareWithChildAndSwap(0);
            return returnValue;
        }

        private void compareWithParentAndSwap(int childIndex){
            if(childIndex == 0) return;
            int child = arr[childIndex];
            int parentIndex = getParentIndex(childIndex);
            int parent = arr[parentIndex];

            if(child < parent){
                arr[childIndex] = parent;
                arr[parentIndex] = child;
                compareWithParentAndSwap(parentIndex);
            }
        }

        private void compareWithChildAndSwap(int parentIndex){
            int parent = arr[parentIndex];
            int leftChildIndex = getLeftChildIndex(parentIndex);
            int rightChildIndex = getRightChildIndex(parentIndex);

            if(rightChildIndex < size){ // 자식 노드가 모두 있는 경우
                int leftChild = arr[leftChildIndex];
                int rightChild = arr[rightChildIndex];
                if(leftChild < rightChild){
                    if(leftChild < parent){
                        arr[parentIndex] = leftChild;
                        arr[leftChildIndex] = parent;
                        compareWithChildAndSwap(leftChildIndex);
                    }
                }else{
                    if(rightChild < parent){
                        arr[parentIndex] = rightChild;
                        arr[rightChildIndex] = parent;
                        compareWithChildAndSwap(rightChildIndex);
                    }
                }
            }else if(leftChildIndex < size  && size <= rightChildIndex){ // 왼쪽 자식만 있는 경우
                int leftChild = arr[leftChildIndex];
                if(leftChild < parent){
                    arr[parentIndex] = leftChild;
                    arr[leftChildIndex] = parent;
                    compareWithChildAndSwap(leftChildIndex);
                }
            }
        }

        private int getParentIndex(int childIndex){
            return (childIndex-1) / 2;
        }

        private int getLeftChildIndex(int parentIndex){
            return (parentIndex * 2) + 1;
        }

        private int getRightChildIndex(int parentIndex){
            return (parentIndex * 2) + 2;
        }

    }

}
