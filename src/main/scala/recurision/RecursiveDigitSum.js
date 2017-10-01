take = (input) => {
    const allCommands = input.split(' ');
    const n = allCommands[0];
    const k = parseInt(allCommands[1]);
    const total = Array(k).fill(n.toString()).reduce((acc , ele) => acc + ele);

    const result = {number: 0};
    process(total, result)
    console.log(result.number);
};

process = (total, result) => {
    if(total.length === 1) {
        result.number = total;
        return;
    }

    process(total.split('').map(t => parseInt(t)).reduce((acc, ele) => acc + ele).toString(), result);
};