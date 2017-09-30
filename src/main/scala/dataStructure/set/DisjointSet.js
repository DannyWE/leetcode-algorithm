Set.prototype.union = function(setB) {
    var union = new Set(this);
    for (var elem of setB) {
        union.add(elem);
    }
    return union;
}

Set.prototype.intersection = function(setB) {
    var intersection = new Set();
    for (var elem of setB) {
        if (this.has(elem)) {
            intersection.add(elem);
        }
    }
    return intersection;
}

disjointSet = (xs) => {

    const t = {
        items: xs.map(e => {
            let set = new Set();
            set.add(e);
            return set;
        }),
        print: (a) => {
            for (let ele of t.items) {
                if (ele.has(a)) {
                    console.log(ele.size);
                    return;
                }
            }
        },
        connect: (a, b) => {
            const set = new Set();
            set.add(a);
            set.add(b);
            removeItem(t.items, a);
            removeItem(t.items, b);
            for (let i = 0; i < t.items.length; i ++) {
                if ((t.items[i].intersection(set)).size > 0) {
                    t.items[i] = t.items[i].union(set);
                    return;
                }
            }
            t.items.push(set);
        }
    };

    return t;
}

removeItem = (items, element) => {
    const index = items.findIndex(e => e.size === 1 && e.has(element));
    if (index !== -1) {
        items.splice(index, 1);
    }
}