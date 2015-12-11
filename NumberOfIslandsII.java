import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] positions = {
				{0,9},
				{5,4},
				{0,12},
				{6,9},
				{6,5},
				{0,4},
				{4,11},
				{0,0},
				{3,5},
				{6,7},
				{3,12},
				{0,5},
				{6,13}	
		};
		int m = 8;
		int n = 14;
		NumberOfIslandsII solution = new NumberOfIslandsII();
		System.out.println(solution.numIslands2(m, n, positions));
	}

	private int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		UnionFind uf = new UnionFind(m, n);
		List<Integer> res = new ArrayList<>();
		for (int[] position : positions) {
			int x = position[0], y = position[1];
			int p = uf.add(x, y);
			for (int[] d : dir) {
				int q = uf.getID(x + d[0], y + d[1]);
				if (q > 0 && !uf.find(p, q)) {
					uf.unite(p, q);
				}
			}
			res.add(uf.size());
		}
		return res;
	}
}

class UnionFind {
	private int[] id;
	private int[] sz;
	private int m, n, count;

	public UnionFind(int m, int n) {
		this.count = 0;
		this.m = m;
		this.n = n;
		this.id = new int[m * n + 1];
		this.sz = new int[m * n + 1];
	}

	public int index(int x, int y) {
		return x * n + y + 1;
	}

	public int size() {
		return count;
	}

	public int getID(int x, int y) {
		if (x >= 0 && x < m && y >= 0 && y < n) {
			return id[index(x, y)];
		}
		return 0;
	}

	public int add(int x, int y) {
		int i = index(x, y);
		id[i] = i; sz[i] = 1;
		count++;
		return i;
	}

	public boolean find(int p, int q) {
		return root(p) == root(q);
	}

	public void unite(int p, int q) {
		int i = root(p), j = root(q);
		if (sz[i] < sz[j]) {
			id[i] = j; sz[j] += sz[i];
		} else {
			id[j] = i; sz[i] += sz[j];
		}
		--count;
	}

	private int root(int i) {
		for (;i != id[i]; i = id[i])
            id[i] = id[id[i]]; //path compression
        return i;
	}
}
