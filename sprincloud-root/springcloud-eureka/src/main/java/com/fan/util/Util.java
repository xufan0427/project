package com.fan.util;

import java.util.Arrays;
import java.util.List;

public class Util {

	
	/**
	 * 冒泡算法
	 * @param ags
	 * @return
	 */
	public int [] maoPao(int [] ags) {
		System.out.println(Arrays.toString(ags));
		for(int i=0;i<ags.length-1;i++) {
			for(int j=0;j<ags.length-i-1;j++) {
				//获取当前值，如果比后面一个大，那么久互换位置
				if(ags[j]>ags[j+1]) {
					int temp=ags[j];
					ags[j]=ags[j+1];
					ags[j+1]=temp;
				}
			}
			System.out.println(Arrays.toString(ags));
		}
		return ags;
	}
	/**
	 * 比较算法
	 * @param ags
	 * @return
	 */
	public int[] bijiao(int [] ags){
		System.out.println(Arrays.toString(ags));
		for(int i=0;i<ags.length-1;i++) {
			int index=i;
			//找到最小的，放到前面
			for(int j=i+1;j<ags.length;j++) {
				if(ags[j]<ags[index]) {
					index=j;
				}
			}
			int temp=ags[index];
			ags[index]=ags[i];
			ags[i]=temp;
		}
		return ags;
	}
	
	public int[] aa(int [] arr) {
		System.out.println(Arrays.toString(arr));
		for(int i=1;i<arr.length;i++) {
			int insertValue=arr[i];
			int insertIndex=i-1;
			 while(insertIndex >=0 && insertValue < arr[insertIndex]){
				arr[insertIndex+1]=arr[insertIndex];
				insertIndex--;
			}
			arr[insertIndex+1]=insertValue;
			System.out.println(Arrays.toString(arr));
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int [] ags= {25,1,8,3,54,12,45,78,1,5,4,1};
		
		Util util= new Util();
		//ags=util.maoPao(ags);
		//ags=util.bijiao(ags);
		ags=util.aa(ags); 
		
		System.out.println(Arrays.toString(ags));
	}
	
}
