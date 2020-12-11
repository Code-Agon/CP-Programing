#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
int level[10001];
vector<int> adj[10001];
int x=0;
int maxheight=0;
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
Node *insert(Node *root, int key,int par=-3)
{
    if (!root){
        adj[par].push_back(key);
         adj[key].push_back(par);
        return new Node(key);
    }
    if(root->data<key){
        root->right=insert(root->right,key,root->data);
    }else{
        root->left=insert(root->left,key,root->data);
    }
    return root;
}
void dfs(int node, int par = -1, int lev = 0)
{

    level[node] = lev;
    for (auto it : adj[node])
    {
        if (it != par)
        {
             if (maxheight < lev+1)
            {
                maxheight = max(maxheight, lev + 1);
                x = it;
            }
            dfs(it, node, lev + 1);
        }
    }
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {

        int n;
        cin>>n;
        x=0;
        maxheight=-1;
        Node *root;
        int arr[n + 1];
        for (int i = 1; i <= n; i++)
        {
            cin >> arr[i];
            arr[i]++;
            if(i==1){ root = new Node(arr[i]);
            level[arr[i]]=1;

            }
            else
            root = insert(root, arr[i]);
        }
        dfs(arr[1]);
        dfs(x);
        cout<<maxheight+1<<"\n";
        for(int i=0;i<10001;i++){
            adj[i].clear();
        }
        
    }
    return 0;
}
