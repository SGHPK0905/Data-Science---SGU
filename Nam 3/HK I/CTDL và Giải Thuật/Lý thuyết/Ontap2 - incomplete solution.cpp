#include <iostream>
#include <stack>
#include <queue>

using namespace std;

void printStack(stack<int> stack2print){
    while (!stack2print.empty())
    {
        cout << stack2print.top() << " ";
        stack2print.pop();
    }
    cout << endl;
}

stack<int> reverse1(stack<int> stack2reverse){
    stack<int> S1, S2;

    while (!stack2reverse.empty()){
        S1.push(stack2reverse.top());
        stack2reverse.pop();
    }

    while (!S1.empty()){
        S2.push(S1.top());
        S1.pop();
    }

    while (!S2.empty()){
        stack2reverse.push(S2.top());
        S2.pop();
    }
    return stack2reverse;
}

stack<int> reverse2(stack<int> stack2reverse){
    queue<int> Q;
    while (!stack2reverse.empty()){
        Q.push(stack2reverse.top());
        stack2reverse.pop();
    }
    while (!Q.empty()){
        stack2reverse.push(Q.front());
        Q.pop();
    }
    return stack2reverse;
}

stack<int> sortStack(stack<int> stack2sort){
    stack<int> tempStack;

    while (!stack2sort.empty())
    {
        int tmp = stack2sort.top();
        cout << tmp << endl;
        stack2sort.pop();
        printStack(stack2sort);
        printStack(tempStack);
        cout << endl;
        while (!tempStack.empty() && tempStack.top() > tmp)
        {
            stack2sort.push(tempStack.top());
            tempStack.pop();
        }

        tempStack.push(tmp);
    }
    return tempStack;
}

stack<int> moveStack1(stack<int> stack2move){
    stack<int> tempStack;

    while (!stack2move.empty()){
        tempStack.push(stack2move.top());
        stack2move.pop();
    }

    while (!tempStack.empty()){
        stack2move.push(tempStack.top());
        tempStack.pop();
    }
    return stack2move;
}


int main()
{
    stack<int> S;
    S.push(3);
    S.push(1);
    S.push(5);
    S.push(9);
    S.push(7);

//    printStack(S);
//    S = reverse1(S);
//    printStack(S);
//
//    S = reverse2(S);
//
//    printStack(S);

    S = sortStack(S);

    printStack(S);

    stack<int> new_S;
    new_S = moveStack1(S);
    printStack(new_S);


}