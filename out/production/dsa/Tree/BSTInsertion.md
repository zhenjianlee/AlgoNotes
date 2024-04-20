## BST Insertion




## My Code - BFS

### Version 2 - Cleaner version - ChatGPT pointed out my mistake

```java
public static Node insert(Node root,int data) {
        
        if(root ==null)return new Node(data); //---> don't return null.wrong.
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            Node curNode = q.poll();
            int curData = curNode.data;
              
            if (data<curData){
                if (curNode.left !=null){
                    q.offer(curNode.left);
                }else{
                    curNode.left = new Node(data);
                    break;
                }
                
            }
            else {
                if (curNode.right != null){
                    q.offer(curNode.right);
                }else{
                    curNode.right= new Node(data);
                    break;
                }
            }
        
        }
        return root;
    }


```

### Version1 - Logic is too messy - wrong answer

See ChatGPT reccomendation:-


Your insertion logic seems to be almost correct. Let's review it:

You traverse the tree level by level using a queue (q).

For each node, you check whether the data to be inserted is less than or greater than the current node's data.

If there's an available left or right child, you enqueue it for further exploration.

If both left and right child are null, you insert the new node at that position based on whether the data is less or greater than the current node's data.

The problem might be with how you handle the case when the left or right child of the current node is null. Let's refine that part:


```java
public static Node insert(Node root,int data) {
        
        if(root ==null)return new Node(data); // -----> don't return null!!!
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            Node curNode = q.poll();
            int curData = curNode.data;
              
            if (curNode.left != null && data<curData){
                q.offer(curNode.left);
            }
            else if (curNode.right !=null && data > curData){
                q.offer(curNode.right);
            }else if (curNode.left == null && curNode.right ==null){
                Node newNode= new Node(data);
                if ( data >curData){
                    curNode.right=newNode;
                    break;
                }else {
                    curNode.left=newNode;
                    break;
                }
            }
        }

    	return root;
    }

```

## Reference code - Recursive Method

```java
public static Node insert(Node root,int data) {
        
        if(root==null){
            root=new Node(data);
            return root;
        }
        
        if(root.data>data){
            root.left = insert(root.left,data);
        }else{
            root.right= insert(root.right,data);
        }
        return root;
    }

```


## Reference code - Non Recursive - WatchandLearn 

Java solution without recursion :

```java
static Node Insert(Node root,int value)
    {
        Node node = new Node();
        node.data = value;
        if(root==null){
            return node;
        }    
        Node tmp = root;       
        while(tmp!=null){
            if(tmp.data > value){
                if(tmp.left !=null)
                    tmp = tmp.left;
                else{
                    tmp.left = node;
                    break;
                }                    
            }
            else if(tmp.right !=null)
                    tmp = tmp.right;
            else{
                tmp.right = node;
                break;
            }                                   
        }
        return root;       
    }

```