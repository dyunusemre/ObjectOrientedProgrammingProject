package oopProject;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JaccardSimilarity  extends ShingleBased implements SimilarityCalculate
{

		@Override
		public double CalculateSimilarity(String s1,String s2) {
	        Map<String, Integer> profile1 = getProfile(s1);
	        Map<String, Integer> profile2 = getProfile(s2);

	        Set<String> union = new HashSet<String>();
	        union.addAll(profile1.keySet());
	        union.addAll(profile2.keySet());

	        int inter = 0;

	        for (String key : union) {
	            if (profile1.containsKey(key) && profile2.containsKey(key)) {
	                inter++;
	            }
	        }

	        return 1.0 * inter / union.size();
		}

	
}
