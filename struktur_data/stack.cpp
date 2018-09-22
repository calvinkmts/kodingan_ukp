template <class T>
class Stack {
public:
	Stack() {
		length = 0;
	}

	void push(T newItem) {
		T * temp = new T[length + 1];
		for (int i = 0; i < length; i++) {
			temp[i] = arr[i];
		}
		temp[length] = newItem;
		delete[] arr;
		arr = temp;
		length++;
	}

	T pop() {
		T item;
		T * temp = new T[length - 1];
		for (int i = 0; i < length - 1; i++) {
			temp[i] = arr[i];
		}
		item = arr[length - 1];
		delete[] arr;
		arr = temp;
		length--;
		return item;
	}

	T top() {
		return arr[top-1];
	}
private:
	T * arr;
	int length;
};
