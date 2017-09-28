//     #
//    ##
//   ###
//  ####
// #####
//######

for (i =1; i<= n; i++) {
    const arr = [...Array(n-i).keys()].map(() => ' ').concat([...Array(i).keys()].map(() => '#'));

    console.log(arr.reduce((acc, ele) => (acc + ele)));
}