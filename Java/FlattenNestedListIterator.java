/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 // take away
 // 1. read the question description carefully!!!
 // 2. when sovling problem of
 //     a) output a sequence of data one by one
 //     b) the order of data does not change
 //     c) data is stored in nested structure like tree, nested list...
 //  consider using stack
public class NestedIterator implements Iterator<Integer> {
    Stack<List<NestedInteger>> objStack = new Stack();
    Stack<Integer> idxStack = new Stack();

    public NestedIterator(List<NestedInteger> nestedList) {

        if(nestedList != null && nestedList.size() > 0){
            objStack.push(nestedList);
            idxStack.push(0);
            // console.log(this.objStack.length)
            extract(nestedList, 0);
        }
    }

    @Override
    public Integer next() {
        List<NestedInteger> arr = objStack.peek();
        int idx = idxStack.peek();
        int nextVal = arr.get(idx).getInteger();

        idx++;
        // console.log('output: ' + nextVal)

        idxStack.pop();
        idxStack.push(idx);

        extract(arr, idx);

        return nextVal;
    }

    @Override
    public boolean hasNext() {
        if(objStack.size() > 0)  return true;
        else return false;
    }

    public void extract(List<NestedInteger> arr, int idx){

        while(arr.size() == 0 || idx >= arr.size() || arr.get(idx).isInteger() == false){
            // console.log('[' + arr + ']')
            if(arr.size() == 0 || idx >= arr.size()){
                // console.log('(1)')
                objStack.pop();
                idxStack.pop();
                if(objStack.size() == 0)
                    break;
                arr = objStack.peek();
                idx = idxStack.peek();
                idx++;
                idxStack.pop();
                idxStack.push(idx);
                // console.log('(1F)')
            }
            else{
                // console.log('(2)')
                objStack.push(arr.get(idx).getList());
                idxStack.push(0);
                arr = objStack.peek();
                idx = idxStack.peek();
                // console.log('(2F)')
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
