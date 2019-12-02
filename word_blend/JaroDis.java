package word_blend_kt;
/**
* calculating JaroWinklerSimilarity
**/
public class JaroDis {
	private float p = 0.0f;//0.1f;
	private final float MAX_P = 0.0f;//0.25f;
	private final int MAX_L = 4;
 
	public JaroDis() {
	}
	
	public JaroDis(float p) {
		this.p=p>MAX_P?MAX_P:p;
	}
	/**
	 * 
	 * @param s1
	 * @param s2
	 * @return Jaro
	 */
	public float JaroSimilarity(String s1, String s2) {
		if (s1 == null || s2 == null) {
			if (s1 == null && s2 == null) {
				return 1.0f;
			}
			return 0.0f;
		}
		int[] matchesInfo = getMatchesInfo(s1, s2);
		if (matchesInfo[0] == 0) {
			return 0.0f;
		} else {
			float m = matchesInfo[0];
			return ((m / s1.length() + m / s2.length() + (m - matchesInfo[1]) / m)) / 3;
		}
	}
	/**
	 * 
	 * @param s1
	 * @param s2
	 * @return Jaro-Winkler
	 */
	public float JaroWinklerSimilarity(String s1, String s2) {
		if (s1 == null || s2 == null) {
			if (s1 == null && s2 == null) {
				return 1.0f;
			}
			return 0.0f;
		}
		int[] matchesInfo = getMatchesInfo(s1, s2);
		if (matchesInfo[0] == 0) {
			return 0.0f;
		} else {
			float m = matchesInfo[0];
			float j = ((m / s1.length() + m / s2.length() + (m - matchesInfo[1]) / m)) / 3;
			return j + matchesInfo[2] * p * (1 - j);
		}
	}
 
	private int[] getMatchesInfo(String s1, String s2) {
		String min, max;
		if (s1.length() < s2.length()) {
			min = s1;
			max = s2;
		} else {
			min = s2;
			max = s1;
		}
		
		int matchRange = Math.max(max.length() / 2 - 1, 0);
		
		boolean[] minMatchFlag = new boolean[min.length()];
		boolean[] maxMatchFlag = new boolean[max.length()];
		
		int matches = 0;
		for (int i = 0; i < min.length(); i++) {
			char minChar = min.charAt(i);
			for (int j = Math.max(i - matchRange, 0); j < Math.min(i + matchRange + 1, max.length()); j++) {
				if (!maxMatchFlag[j] && minChar == max.charAt(j)) {
					maxMatchFlag[j] = true;
					minMatchFlag[i] = true;
					matches++;
					break;
				}
			}
		}
		
		int transpositions = 0;
		
		int prefix = 0;
		
		int j = 0;
		for (int i = 0; i < min.length(); i++) {
			if (minMatchFlag[i]) {
				for (; !maxMatchFlag[j]; j++) {
				}
				if (min.charAt(i) == max.charAt(j) && transpositions == 0) {
					prefix++;
				} else if (min.charAt(i) != max.charAt(j)) {
					transpositions++;
				}
				j++;
			}
		}
		return new int[] { matches, transpositions / 2, prefix > MAX_L ? MAX_L : prefix };
	}


}
