#include "initBD.hpp"
arrays C; variables V05;

double sum(ARRAY fieldA, uint16_t sizeA)
{
    V05.out = 0.0;

    for (uint16_t c = NULL; c < sizeA; c++)
        V05.out += fieldA[c];

    return V05.out;
}

double arAv(ARRAY fieldA, uint16_t sizeA)
{
    V05.out = 0.0;

    for (uint16_t c = NULL; c < sizeA; c++)
        V05.out += fieldA[c];

    return V05.out /= sizeA;
}

double geoAv(ARRAY fieldA, uint16_t sizeA)
{
    V05.out = 1.0;

    for (uint16_t c = NULL; c < sizeA; c++)
        V05.out *= fieldA[c];

    return std::pow(V05.out, 1.0 / sizeA);
}

double qvAv(ARRAY fieldA, uint16_t sizeA)
{
    V05.out = 0.0;

    for (uint16_t c = NULL; c < sizeA; c++)
        V05.out += std::pow(fieldA[c], 2);

    return std::sqrt(V05.out / sizeA);
}

double stdD(ARRAY fieldA, uint16_t sizeA)
{
    V05.p1 = 0.0;
    V05.p2 = 0.0;

    for (uint16_t c = NULL; c < sizeA; c++)
        V05.p1 += fieldA[c];

    for (uint16_t c = NULL; c < sizeA; c++)
        V05.p2 += std::pow(fieldA[c] - (V05.p1 /= sizeA), 2);

    return std::sqrt(V05.p2 / sizeA);
}

double weightAv(ARRAY fieldA, ARRAY fieldB, uint16_t sizeA, uint16_t sizeB)
{
    V05.p1 = 0.0;
    V05.p2 = 0.0;

    for (uint16_t c = NULL; 2 * c < sizeA + sizeB; c++)
    {
        V05.p1 += fieldA[c] * fieldB[c]; V05.p2 += fieldB[c];
    }

    return V05.p1 / V05.p2;
}

bool logOr(ARRLOG fieldLog, uint16_t sizeLog)
{
    V05.outLog = false;

    for (uint16_t c = NULL; c < sizeLog; c++)
        V05.outLog = (V05.outLog || fieldLog[c]);

    return V05.outLog;
}

bool logAnd(ARRLOG fieldLog, uint16_t sizeLog)
{
    V05.outLog = false;

    for (uint16_t c = NULL; c < sizeLog; c++)
        V05.outLog = (V05.outLog && fieldLog[c]);

    return V05.outLog;
}

ARRAY cloneA(ARRAY fieldA, uint16_t sizeA)
{
    C.outA.clear();

    for (uint16_t c = NULL; c < sizeA; c++)
        C.outA.push_back(fieldA[c]);

    return C.outA;
}

ARRAY contAB(ARRAY fieldA, ARRAY fieldB, uint16_t sizeA, uint16_t sizeB)
{
    C.outA.clear();

    for (uint16_t c = NULL; c < sizeA; c++)
        C.outA.push_back(fieldA[c]);

    for (uint16_t c = NULL; c < sizeB; c++)
        C.outA.push_back(fieldB[c]);

    return C.outA;
}