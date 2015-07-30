/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 */
public class RegularExpMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * Matching Cases:
	 * case 1: OPT[i-1][j-1] is true, and ith character of s is equal to jth character 
	 * 		   of p. Or j th character of p is '.'
	 * case 2: OPT[i-1][j] is true, then my pattern now is '*' and preceding character 
	 * 		   is equal to incoming character of s
	 * case 3: OPT[i][j-1] is true, then my pattern now is '*' which can match an empty 
	 * 		   string
	 * case 4: OPT[i][j-2] is true, and the pattern like (a*) matches an empty string
	 */
	public static boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		int m = s.length();
		int n = p.length();

		boolean[][] Opt = new boolean[m + 1][n + 1];
		Opt[0][0] = true;

		for (int i = 1; i <= m; i++) {
			Opt[i][0] = false;
		}
		for (int j = 1; j <= n; j++) {
			Opt[0][j] = p.charAt(j - 1) == '*' && (j - 2 >= 0) && Opt[0][j - 2];
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				//add one char at string and pattern and two chars are same
				if (Opt[i - 1][j - 1] && equals(s, p, i - 1, j - 1)) {
					Opt[i][j] = true;
				}
				//add one char at string: current pattern is '*' and new added string
				//is the same char before *
				//add one char at pattern: new added pattern is '*'
				if ((Opt[i - 1][j] || Opt[i][j - 1]) && p.charAt(j - 1) == '*'
						&& equals(s, p, i - 1, j - 2)) {
					Opt[i][j] = true;
				}
				//add two more char at pattern: add one char and a '*' to match
				//empty string
				if (j - 2 >= 0 && Opt[i][j - 2] && p.charAt(j - 1) == '*') {
					Opt[i][j] = true;
				}
			}
		}

		return Opt[m][n];

	}

	private static boolean equals(String s, String p, int si, int pi) {
		return (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.');

	}
}
