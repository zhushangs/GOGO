package Stack;

//Stack: Last In First Out(LIFO)

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('||s.charAt(i) == '['||s.charAt(i) == '{'){
                stack.add(s.charAt(i));
            }else if((s.charAt(i) == ')'||s.charAt(i) == ']'|| s.charAt(i) == '}') && stack.isEmpty()){
                return false;
            }else if(s.charAt(i) == ')'){
                if(stack.pop() != '('){
                    return false;
                }
            }else if(s.charAt(i) == ']'){
                if(stack.pop() != '['){
                    return false;
                }
            }else if(s.charAt(i) == '}'){
                if(stack.pop() != '{'){
                    return false;
                }
            }
        }
        if(!stack.isEmpty() && !s.equals("")){
            return false;
        }else{
            return true;
        }
    }
}

/*
    empty(): tests if this stack is empty (usually use isEmpty() which is inherited from class java.util.Vector)
    peek(): looks at the object at the top of the stack without removing it from the stack.
    pop(): removes the object at the top of this stack and return that object as the value of this function
    push(): pushes an item onto the top of the stack
    search(): return the 1-based position where an object is on this stack

    ex:
    Stack: [Welcome, To, Geeks, For, Geeks]  ------------ push()
    The element at the top of the stack is: Geeks ------- peek()
    Popped element: Geeks ---------- pop()
 */
