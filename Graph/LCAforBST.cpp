#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
int level[10000];
vector<int> adj[200009];
int parent[200009][21];
struct Node
{
    int data;
    Node *left, *right;
    Node(int value)
    {
        data = value;
        left = right = NULL;
    }
};
Node *insert(Node *root, int key,int par=-1)
{
    if (!root){
        adj[par].push_back(key);
        return new Node(key);
    }
    if(root->data<key){
        root->right=insert(root->right,key,root->data);
    }else{
        root->left=insert(root->left,key,root->data);
    }
    return root;
}
void dfs(int node, int par = 0, int lev = 0)
{
    parent[node][0] = par;
    for (int i = 1; i < 21; i++)
    {
        parent[node][i] = parent[parent[node][i - 1]][i - 1];
    }

    level[node] = lev;
    for (auto it : adj[node])
    {
        if (it != par)
        {
            dfs(it, node, lev + 1);
            ;
        }
    }
}
int lca(int u, int v)
{
    if (level[u] < level[v])
        swap(u, v);
    int dis = level[u] - level[v];
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
        return v;
    for (int i = 20; i >= 0; i--)
    {
        int p1 = parent[u][i];
        int p2 = parent[v][i];
        if (p1 != p2)
        {
            u = p1;
            v = p2;
        }
    }
    return parent[u][0];
}
int main()
{
    int t;
    cin >> t;
    while (t--)
    {

        int n, q;
        cin>>n>>q;
        Node *root;
        int arr[n + 1];
        for (int i = 1; i <= n; i++)
        {
            cin >> arr[i];
            arr[i]++;
            if(i==1){ root = new Node(arr[i]);
            
            }
            else
            root = insert(root, arr[i]);
        }
        dfs(arr[1]);
        
        for (int k = 0; k < q; k++)
        {
            int m, x;
            cin >> m >> x;
            m++;
            x++;
            int ans = lca(m,x);
          
            cout << ans-1 << " ";
        }
        cout<<"\n";
        for(int i=0;i<10001;i++){
            adj[i].clear();
        }
        for(int i=0;i<10001;i++){
            for(int j=0;j<21;j++) parent[i][j]=-1;
        }
    }
    return 0;
}
