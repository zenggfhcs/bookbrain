package com.lib.bookbrain.utils;

import java.util.Random;

public class LibraryIndexGenerator {

public static void main(String[] args) {
	String classNumber = "TP247.5";
	String sectionNumber = "2-B";
	int sequenceNumber = 123;

	System.out.println(formClassAndSeq(classNumber, sequenceNumber));

//	String indexNumber = generateIndexNumber(classNumber, sectionNumber, sequenceNumber);
//	System.out.println("生成的索引号是: " + indexNumber);
}

public static String generateIndexNumber(String classNumber, String sectionNumber, int sequenceNumber) {
	String indexNumber = classNumber + "-" + sectionNumber + "-" + sequenceNumber;
	String checkDigit = generateCheckDigit(indexNumber);
	return indexNumber + "-" + checkDigit;
}

public static String formClassAndSeq(String classStr, Integer seq) {
	String[] strings = classStr.split("");
	return String.join("-", strings);
}

public static String generateCheckDigit(String indexNumber) {
	// 这里使用一个简单的随机数生成校验码，实际应用中可能需要更复杂的算法
	Random random = new Random(47);
	int checkDigit = random.nextInt(10); // 生成0到9的随机数
	return String.valueOf(checkDigit);
}
}
