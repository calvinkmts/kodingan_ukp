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

	void view() {
		for (int i = length - 1; i >= 0; i--) {
			if (i != length - 1) cout << " ";
			cout << arr[i];
		}
		cout << endl;
	}
private:
	T * arr;
	int length;
};
