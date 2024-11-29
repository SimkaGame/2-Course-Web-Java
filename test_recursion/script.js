function factorial(n)
{
    if (typeof(n) != "number" || n < 0)
        throw Error("Not correct data");
    if (n < 2)
        return n;
    else 
    {   
        setTimeout(() => console.log("Test"), 10000);
        return n * factorial(n - 1);
    }
}
console.log(factorial(1000));