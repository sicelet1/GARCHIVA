//Including standard headers required by the program
#include <iostream>
#include <vector>
#include <algorithm>

//The program starts executing from here:
int main(void)
{
	//Variables / Objects initialization on the stack memory
	std::vector<__int64> Input;
	__int64 InputBuf = NULL;

	//Asking for a numeric input until zero is entered
	do
	{
		std::cin >> InputBuf;
		Input.emplace_back(InputBuf);
	}
	while (InputBuf != NULL);

	//Getting rid of that zero [last element]
	Input.pop_back();
	//Sorting the array of numbers [Input] using a standard sort algorithm [Quick sort]
	std::sort(Input.begin(), Input.end());
	//Calculating & printing the median of that SORTED number array [Input]
	//Calculation is based on the element count of that SORTED number array [Input]:
	//If the size is odd => Median is simply the middle element of that SORTED number array [Input]
	//If the size is even => Median is an arithmetic average of the two middle elements of that SORTED number array [Input]
	std::cout << "\nMedian = " << (Input.size() % 2 == 0 ? (double)(Input[Input.size() / 2] + Input[(Input.size() / 2) - 1]) / 2.0 : Input[(Input.size() - 1) / 2]);
	std::cin.get();

	//The execution ends
	return NULL;
};