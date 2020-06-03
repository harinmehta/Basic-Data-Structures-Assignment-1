// package com.basicDS;

import java.io.*;
import java.util.*;

public class MaxSlidingWindow {

	static Reader sc = new Reader();
	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) throws IOException {
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int windowSize = sc.nextInt();
		
		int[] ans = new int[n - windowSize + 1];
		
		Deque<Integer> deque = new LinkedList<>(); 
		
		int index = 0;
		
		for(; index < windowSize; index++) {
			while(!deque.isEmpty() && deque.getLast() < arr[index]) {
				deque.removeLast();
			}
			deque.addLast(arr[index]);
		}
		
		// index == windowSize
		int ansIndex = 0;
		ans[ansIndex++] = deque.getFirst();
		
		for(; index < n; index ++) {
			
			if(deque.getFirst() == arr[index - windowSize]) {
				deque.removeFirst();
			}
			while(!deque.isEmpty() && deque.getLast() < arr[index]) {
				deque.removeLast();
			}
			deque.addLast(arr[index]);
			ans[ansIndex++] = deque.getFirst();	
		}
		
		for(int x : ans) {
			out.print(x+" ");
		}
		out.close();
	}
	// for fast I/O operations, the code may fail without this.
	static class Reader 
	{ 
	    final private int BUFFER_SIZE = 1 << 16; 
	    private DataInputStream din; 
	    private byte[] buffer; 
	    private int bufferPointer, bytesRead; 
	
	    public Reader() 
	    { 
	        din = new DataInputStream(System.in); 
	        buffer = new byte[BUFFER_SIZE]; 
	        bufferPointer = bytesRead = 0; 
	    } 
	
	    public Reader(String file_name) throws IOException 
	    { 
	        din = new DataInputStream(new FileInputStream(file_name)); 
	        buffer = new byte[BUFFER_SIZE]; 
	        bufferPointer = bytesRead = 0; 
	    } 
	
	    public String readLine() throws IOException 
	    { 
	        byte[] buf = new byte[64]; 
	        int cnt = 0, c; 
	        while ((c = read()) != -1) 
	        { 
	            if (c == '\n') 
	                break; 
	            buf[cnt++] = (byte) c; 
	        } 
	        return new String(buf, 0, cnt); 
	    } 
	
	    public int nextInt() throws IOException 
	    { 
	        int ret = 0; 
	        byte c = read(); 
	        while (c <= ' ') 
	            c = read(); 
	        boolean neg = (c == '-'); 
	        if (neg) 
	            c = read(); 
	        do
	        { 
	            ret = ret * 10 + c - '0'; 
	        }  while ((c = read()) >= '0' && c <= '9'); 
	
	        if (neg) 
	            return -ret; 
	        return ret; 
	    } 
	
	    public long nextLong() throws IOException 
	    { 
	        long ret = 0; 
	        byte c = read(); 
	        while (c <= ' ') 
	            c = read(); 
	        boolean neg = (c == '-'); 
	        if (neg) 
	            c = read(); 
	        do { 
	            ret = ret * 10 + c - '0'; 
	        } 
	        while ((c = read()) >= '0' && c <= '9'); 
	        if (neg) 
	            return -ret; 
	        return ret; 
	    } 
	
	    public double nextDouble() throws IOException 
	    { 
	        double ret = 0, div = 1; 
	        byte c = read(); 
	        while (c <= ' ') 
	            c = read(); 
	        boolean neg = (c == '-'); 
	        if (neg) 
	            c = read(); 
	
	        do { 
	            ret = ret * 10 + c - '0'; 
	        } 
	        while ((c = read()) >= '0' && c <= '9'); 
	
	        if (c == '.') 
	        { 
	            while ((c = read()) >= '0' && c <= '9') 
	            { 
	                ret += (c - '0') / (div *= 10); 
	            } 
	        } 
	
	        if (neg) 
	            return -ret; 
	        return ret; 
	    } 
	
	    private void fillBuffer() throws IOException 
	    { 
	        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
	        if (bytesRead == -1) 
	            buffer[0] = -1; 
	    } 
	
	    private byte read() throws IOException 
	    { 
	        if (bufferPointer == bytesRead) 
	            fillBuffer(); 
	        return buffer[bufferPointer++]; 
	    } 
	
	    public void close() throws IOException 
	    { 
	        if (din == null) 
	            return; 
	        din.close(); 
	    } 
	}
}
