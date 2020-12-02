

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
int level[200009];
int subtree[200009];
int maxHeight = 0;
vector<int> adj[200009];
int x = 0;
void dfs(int node, int par = 0, int lev = 0)
{

    level[node] = lev;

    subtree[node] = 1;
    for (auto it : adj[node])
    {
        if (it != par)
        {
            if (maxHeight < lev+1)
            {
                maxHeight = max(maxHeight, lev + 1);
                x = it;
            }
            dfs(it, node, lev + 1);

            subtree[node] += subtree[it];
        }
    }
}
int main()
{

    int n;
    scanf("%d", &n);

    for (int i = 0; i < n - 1; i++)
    {
        int u, v;
        scanf("%d%d", &u, &v);
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    dfs(1);
    int level[n + 1] = {0};
    dfs(x);
    cout << maxHeight << "\n";

    return 0;
}
