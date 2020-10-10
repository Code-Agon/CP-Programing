/**
You are given a 2D grid. A '#' represents an obstacle and a '.' represents free space. 
You need to find the areas of the disconnected components. The cells (i+1, j), (i, j+1), (i-1, j), (i, j-1) are the adjacent to the cell (i, j).

input:     
3             
3 3
##.
..#
#.#
3 5              
#.#.#
.#.#.
#.#.#
4 4
..##
..##
##..
##..

output:

2
1 3 
7
1 1 1 1 1 1 1 
2
4 4 
**/

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int up[] = {1, 0, -1, 0};
int low[] = {0, 1, 0, -1};
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n, m;
        cin >> n >> m;
        char arr[n + 5][m + 5];
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
                cin >> arr[i][j];
        }
        vector<int> vv;
        for (int i = 1; i <= n; i++)
        {
            vector<pair<int, int>> v;
            int count = 0;
            for (int j = 1; j <= m; j++)
            {
                if (arr[i][j] == '.')
                {
                    count++;
                    arr[i][j] = '#';
                    v.push_back({i, j});
                    while (v.size() > 0)
                    {
                        pair<int, int> p = v.back();
                        v.pop_back();
                        for (int lo = 0; lo < 4; lo++)
                        {
                            if (arr[p.first + up[lo]][p.second + low[lo]] == '.')
                            {
                                arr[p.first + up[lo]][p.second + low[lo]] = '#';
                                v.push_back({p.first + up[lo], p.second + low[lo]});
                                count++;
                            }
                        }
                    }
                    if (count != 0)
                    {
                        vv.push_back(count);
                    }

                    count = 0;
                }
            }
        }
        cout << vv.size() << "\n";
        for (auto it : vv)
        {
            cout << it << " ";
        }
        cout << "\n";
    }

    return 0;
}
