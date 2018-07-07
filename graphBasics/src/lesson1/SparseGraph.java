package lesson1;

import java.util.Vector;

/**
 *  稀疏图 - 邻接表
 */
public class SparseGraph {

    /* 节点数 */
    private int n;
    /* 边数 */
    private int m;
    /* 是否为有向图 */
    private boolean directed;
    /* 图的具体数据 */
    private Vector<Integer>[] g;

    public SparseGraph (int n ,boolean directed) {

        assert n >= 0;
        this.n = n;
        this.m = 0;    // 初始化没有任何边
        this.directed = directed;

        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = new Vector[n];
        for(int i = 0 ; i < n ; i ++)
            g[i] = new Vector<Integer>();

    }

    public int V(){ return n;} // 返回节点个数
    public int E(){ return m;} // 返回边的个数

    public void addEdge(int v,int w) {

        assert v >=0 && v<n;
        assert w >=0 && w<n;
        g[v].add(w);
        if(v!=w && !directed) {
            // 无向图
            g[w].add(v);
        }
        m++;
    }

    /*
    验证图中是否有从v到w的边
     */
    public  boolean hasEdge(int v, int w) {

        assert v >=0 && v<n;
        assert w >=0 && w<n;

        for( int i = 0 ; i < g[v].size() ; i ++ ){
            if( g[v].elementAt(i) == w )
                return true;
        }
        return false;
    }

}
