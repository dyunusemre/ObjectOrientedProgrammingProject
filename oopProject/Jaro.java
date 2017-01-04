package oopProject;


public class Jaro implements SimilarityCalculate {

	private String getSetOfMatchingCharacterWithin(String first, String second, int limit)
    {

        StringBuilder common = new StringBuilder();
        StringBuilder copy = new StringBuilder(second);
        for (int i = 0; i < first.length(); i++)
        {
            char ch = first.charAt(i);
            boolean found = false;

            for (int j = Math.max(0, i - limit); !found && j < Math.min(i + limit, second.length()); j++)
            {
                if (copy.charAt(j) == ch)
                {
                    found = true;
                    common.append(ch);
                    copy.setCharAt(j,'*');
                }
            }
        }
        return common.toString();
    }

    private int transpositions(String first, String second)
    {
        int transpositions = 0;
        for (int i = 0; i < first.length(); i++)
        {
            if (first.charAt(i) != second.charAt(i))
            {
                transpositions++;
            }
        }
        transpositions /= 2;
        return transpositions;
    }


	@Override
	public double CalculateSimilarity(String first, String second) {
		String shorter;
        String longer;

  
        if (first.length() > second.length())
        {
            longer = first.toLowerCase();
            shorter = second.toLowerCase();
        }
        else
        {
            longer = second.toLowerCase();
            shorter = first.toLowerCase();
        }


        int halflength = (shorter.length() / 2) + 1;


        String m1 = getSetOfMatchingCharacterWithin(shorter, longer, halflength);
        String m2 = getSetOfMatchingCharacterWithin(longer, shorter, halflength);


       
        if (m1.length() == 0 || m2.length() == 0) return 0.0;


        if (m1.length() != m2.length()) return 0.0;

        int transpositions = transpositions(m1, m2);

        double dist =
                (m1.length() / ((double)shorter.length()) +
                m2.length() / ((double)longer.length()) +
                (m1.length() - transpositions) / ((double)m1.length())) / 3.0;
        
        return dist;
	}

}