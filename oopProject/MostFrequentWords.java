package oopProject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class MostFrequentWords{
	
	public class Word implements Comparable<Word>{
		String word;
		int count;

		@Override
		public int hashCode(){
			return word.hashCode();
		}

		@Override
		public boolean equals(Object obj){
			return word.equals(((Word)obj).word);
		}

		@Override
		public int compareTo(Word b){
			return b.count - count;
		}
	}

	public TreeSet<Word> getWords(String FilePath)	throws IOException{


		Map<String, Word> countMap = new HashMap<String, Word>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FilePath)));
		String line;
		while ((line = reader.readLine()) != null) {
			
			String[] words = line.split("[^A-ZÃ…Ã„Ã–a-zÃ¥Ã¤Ã¶]+");
			
			for (String word : words) {
				if ("".equals(word)) {
					continue;
				}

				Word wordObj = countMap.get(word);
				if (wordObj == null) {
					wordObj = new Word();
					wordObj.word = word;
					wordObj.count = 0;
					countMap.put(word, wordObj);
				}

				wordObj.count++;
			}
		}

		reader.close();

		return new TreeSet<Word>(countMap.values());
		
	}
}
