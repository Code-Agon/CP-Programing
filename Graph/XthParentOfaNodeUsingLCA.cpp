
/** Using LeastCommonAnsister **/
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
    int count = 0;
    while (v > 0)
    {

        if ((v & 1) != 0)
        {
            u = parent[u][count];
        }
        count++;
        v = v >> 1;
    }
    return u;
}
int main()
{

    int n,q;
    scanf("%d%d", &n,&q);

    for (int i = 2; i < n+1; i++)
    {
        int u;
        scanf("%d", &u);
        adj[u].push_back(i);
        
    }
    dfs(1);
    for(int k=0;k<q;k++){
        int m,x;
        cin>>m>>x;
        int ans = lca(m,x);
        if(ans==0) ans=-1;
        cout<<ans<<"\n";
    }
    return 0;
}
