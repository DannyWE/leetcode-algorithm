//https://leetcode.com/problems/divide-two-integers/description/


divide = (dividend, divisor) => {
    if (divisor === 0) {
        return Number.MAX_VALUE;
    }

    if (dividend === 0) {
        return 0;
    }

    let result = 0,
        temp,
        i = 0;

    const isNeg = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0;

    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);

    if (divisor === 1 || divisor === -1) {
        return isNeg? -dividend : dividend;
    }

    temp = divisor;

    while (divisor << (i + 1) <= dividend) {
        i++;
    }

    while (dividend >= divisor) {
        temp = divisor << i;

        if (dividend >= temp) {
            result += (1 << i);
            dividend -= temp;
        }

        i--;
    }

    return isNeg? -result : result;
};