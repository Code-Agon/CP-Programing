#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
int level[200009];
int subtree[200009];
vector<int> adj[200009];
int maxHeight = 0;
int parent[200009][21];
void dfs(int node, int par = 0, int lev = 0)
{
    parent[node][0] = par;
    for (int i = 1; i < 21; i++)
    {
        parent[node][i] = parent[parent[node][i - 1]][i - 1];
    }

    level[node] = lev;
    maxHeight = max(maxHeight, lev + 1);
    subtree[node] = 1;
    for (auto it : adj[node])
    {
        if (it != par)
        {
            dfs(it, node, lev + 1);
            subtree[node] += subtree[it];
        }
    }
}
int lca(int u, int v)
{

    int tot = 0;
    if (level[u] < level[v])
        swap(u, v);
    int dis = level[u] - level[v];
    tot += dis;
    int count = 0;
    while (dis > 0)
    {

        if ((dis & 1) != 0)
        {
            u = parent[u][count];
        }
        count++;
        dis = dis >> 1;
    }
    if (u == v)
        return tot;

    for (int i = 20; i >= 0; i--)
    {

        int p1 = parent[u][i];
        int p2 = parent[v][i];
        if (p1 != p2)
        {
            u = p1;
            v = p2;
            tot += (2 * (1 << i));
        }
    }
    if (v != u)
    {
        tot += 2;
    }
    return tot;
}
int main()
{

    int n, q;
    scanf("%d%d", &n, &q);

    for (int i = 2; i < n + 1; i++)
    {
        int u, v;
        scanf("%d%d", &u, &v);
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    dfs(1);
    for (int k = 0; k < q; k++)
    {
        int m, x;
        cin >> m >> x;
        int ans = lca(m, x);
        cout << ans << "\n";
    }
    return 0;
}
