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
    if(level[u]<level[v]) swap(u,v);
    int dis = level[u]-level[v];
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
    if(u==v) return v;
    for(int i=20;i>=0;i--){
        int p1 = parent[u][i];
        int p2=parent[v][i];
        if(p1!=p2){
            u=p1;
            v=p2;
        }
    }
    return parent[u][0];
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
