#include <iostream>

class Statistiky
{
public:
	const enum Trida : uint64_t
	{
		A = 0, B, C, D, E
	};

	const enum Obor : uint64_t
	{
		Hu = 0, Pr, Pg
	};
};

class Skola : public Statistiky
{
public:
	uint64_t GetObor(const Trida& _T) noexcept
	{
		switch (_T)
		{
		case Trida::A:
		case Trida::B:
			return Obor::Hu;

		case Trida::C:
		case Trida::D:
			return Obor::Pr;

		case Trida::E:
			return Obor::Pg;
		}

		return NULL;
	}
};

int main(void)
{
	Skola S; std::cout << S.GetObor(S.E);
}