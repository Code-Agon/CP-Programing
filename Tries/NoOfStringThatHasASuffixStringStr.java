/**
https://www.hackerearth.com/practice/data-structures/advanced-data-structures/trie-keyword-tree/practice-problems/algorithm/tries-78733022/description/
We're going to make our own Contacts application! The application must perform two types of operations:
add name, where name is a string denoting a contact name. This must store name as a new contact in the application.
find partial, where partial is a string denoting a partial name to search the application for. It must count the number of
contacts starting with partial and print the count on a new line.
Given n sequential add and find operations, perform each operation in order.

Input Format:

The first line contains a single integer, n, denoting the number of operations to perform. 
Each line i of the n subsequent lines contains an operation in one of the two forms defined above.

Output Format

For each find partial operation, print the number of contact names starting with partial on a new line.

Constraints

1 <= n <= 105
1 <= |name| <=21
1 <= |partial| <=21
It is guaranteed that name and partial contain lowercase English letters only.
The input doesn't have any duplicate name for the add operation.
 

SAMPLE INPUT 
4
add hack
add hackerrank
find hac
find hak
SAMPLE OUTPUT 
2
0
**/


import java.util.*;
class Trie{
    Trie arr[] = new Trie[26];
    int count;
    Trie(){
        for(int i=0;i<26;i++) arr[i]=null;
        count=0;
    }
}
public class HelloWorld{
    public static void  buildTri(Trie head,String str){
        Trie current = head;
        for(int i=0;i<str.length();i++){
            if(current.arr[str.charAt(i)-'a']==null){
                current.arr[str.charAt(i)-'a']=new Trie();
            }
            current = current.arr[str.charAt(i)-'a'];
             current.count++;
        }
    }
    public static int getCount(Trie head,String str){
         Trie current = head;
        for(int i=0;i<str.length();i++){
            if(current.arr[str.charAt(i)-'a']==null){
                return 0;
            }
            current = current.arr[str.charAt(i)-'a'];
        }
        return current.count;
    }
     public static void main(String []args){
         Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Trie head = new Trie();
        for(int i=0;i<n;i++){
            String str = sc.next();
            String str2 = sc.next();
            if(str.equals("add")){
                
                buildTri(head,str2);
            }else{
                int ans = getCount(head,str2);
                System.out.println(ans);
            }
        }
     }
}
