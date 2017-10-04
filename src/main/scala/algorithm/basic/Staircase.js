//     #
//    ##
//   ###
//  ####
// #####
//######

for (i =1; i<= n; i++) {
    const arr = [...new Array(n-i).keys()].map(() => ' ').concat([...new Array(i).keys()].map(() => '#'));

    console.log(arr.reduce((acc, ele) => (acc + ele)));
}