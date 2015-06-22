public class RegularExpMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
				if (Opt[i - 1][j - 1] && equals(s, p, i - 1, j - 1)) {
					Opt[i][j] = true;
				}
				if ((Opt[i - 1][j] || Opt[i][j - 1]) && p.charAt(j - 1) == '*'
						&& equals(s, p, i - 1, j - 2)) {
					Opt[i][j] = true;
				}
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
