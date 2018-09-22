template <class T>
class Queue {
public:
	Queue() {
		length = 0;
	}

	void queue(T newItem) {
		T * temp = new T[length + 1];
		for (int i = 0; i < length; i++) {
			temp[i] = arr[i];
		}
		temp[length] = newItem;
		//delete[] arr;
		arr = temp;
		length++;
	}

	T dequeue() {
		T item;
		item = arr[0];
		T * temp = new T[length - 1];
		for (int i = 0; i < length - 1; i++) {
			temp[i] = arr[i+1];
		}
		//delete[] arr;
		arr = temp;
		length--;
		return item;
	}

	void front() {
		cout << arr[0] << endl;
	}
private:
	T * arr;
	int length;
};
