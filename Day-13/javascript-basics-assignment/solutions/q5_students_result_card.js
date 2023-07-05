// Write a program to display one result card of 100 students
// with their name and percentage
// Out of 100 students, 50 has subjects - Grammer and Accounts
// and other 50 has subjects -  Grammer and Physics

// Hint : You need to calculate percentage of 100 students having different set of subjects.
//        You can assume their scores on their respective subjects.


// Write your code here

/* eslint-disable max-len */
const result = () => {
    const studentsList = [
        { name: 'a', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Accounts', marks: 56 }] },
        { name: 'b', subjects: [{ subject: 'Grammer', marks: 54 }, { subject: 'Accounts', marks: 100 }] },
        { name: 'c', subjects: [{ subject: 'Grammer', marks: 90 }, { subject: 'Accounts', marks: 56 }] },
        { name: 'd', subjects: [{ subject: 'Grammer', marks: 70 }, { subject: 'Accounts', marks: 89 }] },
        { name: 'e', subjects: [{ subject: 'Grammer', marks: 88 }, { subject: 'Accounts', marks: 73 }] },
        { name: 'f', subjects: [{ subject: 'Grammer', marks: 95 }, { subject: 'Accounts', marks: 94 }] },
        { name: 'g', subjects: [{ subject: 'Grammer', marks: 63 }, { subject: 'Accounts', marks: 90 }] },
        { name: 'h', subjects: [{ subject: 'Grammer', marks: 80 }, { subject: 'Accounts', marks: 89 }] },
        { name: 'i', subjects: [{ subject: 'Grammer', marks: 85 }, { subject: 'Accounts', marks: 98 }] },
        { name: 'j', subjects: [{ subject: 'Grammer', marks: 50 }, { subject: 'Physics', marks: 80 }] },
        { name: 'k', subjects: [{ subject: 'Grammer', marks: 60 }, { subject: 'Physics', marks: 69 }] },
        { name: 'l', subjects: [{ subject: 'Grammer', marks: 98 }, { subject: 'Physics', marks: 93 }] },
        { name: 'm', subjects: [{ subject: 'Grammer', marks: 85 }, { subject: 'Physics', marks: 74 }] },
        { name: 'n', subjects: [{ subject: 'Grammer', marks: 100 }, { subject: 'Physics', marks: 98 }] },
        { name: 'o', subjects: [{ subject: 'Grammer', marks: 56 }, { subject: 'Physics', marks: 98 }] },
        { name: 'p', subjects: [{ subject: 'Grammer', marks: 100 }, { subject: 'Physics', marks: 79 }] },
        { name: 'q', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Physics', marks: 69 }] },
        { name: 'r', subjects: [{ subject: 'Grammer', marks: 78 }, { subject: 'Physics', marks: 53 }] },
        { name: 's', subjects: [{ subject: 'Grammer', marks: 83 }, { subject: 'Physics', marks: 44 }] },
        { name: 't', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Physics', marks: 86 }] },
        { name: 'a1', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Accounts', marks: 56 }] },
        { name: 'b1', subjects: [{ subject: 'Grammer', marks: 54 }, { subject: 'Accounts', marks: 100 }] },
        { name: 'c1', subjects: [{ subject: 'Grammer', marks: 90 }, { subject: 'Accounts', marks: 56 }] },
        { name: 'd1', subjects: [{ subject: 'Grammer', marks: 70 }, { subject: 'Accounts', marks: 89 }] },
        { name: 'e1', subjects: [{ subject: 'Grammer', marks: 88 }, { subject: 'Accounts', marks: 73 }] },
        { name: 'f1', subjects: [{ subject: 'Grammer', marks: 95 }, { subject: 'Accounts', marks: 94 }] },
        { name: 'g1', subjects: [{ subject: 'Grammer', marks: 63 }, { subject: 'Accounts', marks: 90 }] },
        { name: 'h1', subjects: [{ subject: 'Grammer', marks: 80 }, { subject: 'Accounts', marks: 89 }] },
        { name: 'i1', subjects: [{ subject: 'Grammer', marks: 85 }, { subject: 'Accounts', marks: 98 }] },
        { name: 'j1', subjects: [{ subject: 'Grammer', marks: 50 }, { subject: 'Physics', marks: 80 }] },
        { name: 'k1', subjects: [{ subject: 'Grammer', marks: 60 }, { subject: 'Physics', marks: 69 }] },
        { name: 'l1', subjects: [{ subject: 'Grammer', marks: 98 }, { subject: 'Physics', marks: 93 }] },
        { name: 'm1', subjects: [{ subject: 'Grammer', marks: 85 }, { subject: 'Physics', marks: 74 }] },
        { name: 'n1', subjects: [{ subject: 'Grammer', marks: 100 }, { subject: 'Physics', marks: 98 }] },
        { name: 'o1', subjects: [{ subject: 'Grammer', marks: 56 }, { subject: 'Physics', marks: 98 }] },
        { name: 'p1', subjects: [{ subject: 'Grammer', marks: 100 }, { subject: 'Physics', marks: 79 }] },
        { name: 'q1', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Physics', marks: 69 }] },
        { name: 'r1', subjects: [{ subject: 'Grammer', marks: 78 }, { subject: 'Physics', marks: 53 }] },
        { name: 's1', subjects: [{ subject: 'Grammer', marks: 83 }, { subject: 'Physics', marks: 44 }] },
        { name: 't1', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Physics', marks: 86 }] },
        { name: 'a2', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Accounts', marks: 56 }] },
        { name: 'b2', subjects: [{ subject: 'Grammer', marks: 54 }, { subject: 'Accounts', marks: 100 }] },
        { name: 'c2', subjects: [{ subject: 'Grammer', marks: 90 }, { subject: 'Accounts', marks: 56 }] },
        { name: 'd2', subjects: [{ subject: 'Grammer', marks: 70 }, { subject: 'Accounts', marks: 89 }] },
        { name: 'e2', subjects: [{ subject: 'Grammer', marks: 88 }, { subject: 'Accounts', marks: 73 }] },
        { name: 'f2', subjects: [{ subject: 'Grammer', marks: 95 }, { subject: 'Accounts', marks: 94 }] },
        { name: 'g2', subjects: [{ subject: 'Grammer', marks: 63 }, { subject: 'Accounts', marks: 90 }] },
        { name: 'h2', subjects: [{ subject: 'Grammer', marks: 80 }, { subject: 'Accounts', marks: 89 }] },
        { name: 'i2', subjects: [{ subject: 'Grammer', marks: 85 }, { subject: 'Accounts', marks: 98 }] },
        { name: 'j2', subjects: [{ subject: 'Grammer', marks: 50 }, { subject: 'Physics', marks: 80 }] },
        { name: 'k2', subjects: [{ subject: 'Grammer', marks: 60 }, { subject: 'Physics', marks: 69 }] },
        { name: 'l2', subjects: [{ subject: 'Grammer', marks: 98 }, { subject: 'Physics', marks: 93 }] },
        { name: 'm2', subjects: [{ subject: 'Grammer', marks: 85 }, { subject: 'Physics', marks: 74 }] },
        { name: 'n2', subjects: [{ subject: 'Grammer', marks: 100 }, { subject: 'Physics', marks: 98 }] },
        { name: 'o2', subjects: [{ subject: 'Grammer', marks: 56 }, { subject: 'Physics', marks: 98 }] },
        { name: 'p2', subjects: [{ subject: 'Grammer', marks: 100 }, { subject: 'Physics', marks: 79 }] },
        { name: 'q2', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Physics', marks: 69 }] },
        { name: 'r2', subjects: [{ subject: 'Grammer', marks: 78 }, { subject: 'Physics', marks: 53 }] },
        { name: 's2', subjects: [{ subject: 'Grammer', marks: 83 }, { subject: 'Physics', marks: 44 }] },
        { name: 't2', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Physics', marks: 86 }] },
        { name: 'a3', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Accounts', marks: 56 }] },
        { name: 'b3', subjects: [{ subject: 'Grammer', marks: 54 }, { subject: 'Accounts', marks: 100 }] },
        { name: 'c3', subjects: [{ subject: 'Grammer', marks: 90 }, { subject: 'Accounts', marks: 56 }] },
        { name: 'd3', subjects: [{ subject: 'Grammer', marks: 70 }, { subject: 'Accounts', marks: 89 }] },
        { name: 'e3', subjects: [{ subject: 'Grammer', marks: 88 }, { subject: 'Accounts', marks: 73 }] },
        { name: 'f3', subjects: [{ subject: 'Grammer', marks: 95 }, { subject: 'Accounts', marks: 94 }] },
        { name: 'g3', subjects: [{ subject: 'Grammer', marks: 63 }, { subject: 'Accounts', marks: 90 }] },
        { name: 'h3', subjects: [{ subject: 'Grammer', marks: 80 }, { subject: 'Accounts', marks: 89 }] },
        { name: 'i3', subjects: [{ subject: 'Grammer', marks: 85 }, { subject: 'Accounts', marks: 98 }] },
        { name: 'j3', subjects: [{ subject: 'Grammer', marks: 50 }, { subject: 'Physics', marks: 80 }] },
        { name: 'k3', subjects: [{ subject: 'Grammer', marks: 60 }, { subject: 'Physics', marks: 69 }] },
        { name: 'l3', subjects: [{ subject: 'Grammer', marks: 98 }, { subject: 'Physics', marks: 93 }] },
        { name: 'm3', subjects: [{ subject: 'Grammer', marks: 85 }, { subject: 'Physics', marks: 74 }] },
        { name: 'n3', subjects: [{ subject: 'Grammer', marks: 100 }, { subject: 'Physics', marks: 98 }] },
        { name: 'o3', subjects: [{ subject: 'Grammer', marks: 56 }, { subject: 'Physics', marks: 98 }] },
        { name: 'p3', subjects: [{ subject: 'Grammer', marks: 100 }, { subject: 'Physics', marks: 79 }] },
        { name: 'q3', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Physics', marks: 69 }] },
        { name: 'r3', subjects: [{ subject: 'Grammer', marks: 78 }, { subject: 'Physics', marks: 53 }] },
        { name: 's3', subjects: [{ subject: 'Grammer', marks: 83 }, { subject: 'Physics', marks: 44 }] },
        { name: 't3', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Physics', marks: 86 }] },
        { name: 'a4', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Accounts', marks: 56 }] },
        { name: 'b4', subjects: [{ subject: 'Grammer', marks: 54 }, { subject: 'Accounts', marks: 100 }] },
        { name: 'c4', subjects: [{ subject: 'Grammer', marks: 90 }, { subject: 'Accounts', marks: 56 }] },
        { name: 'd4', subjects: [{ subject: 'Grammer', marks: 70 }, { subject: 'Accounts', marks: 89 }] },
        { name: 'e4', subjects: [{ subject: 'Grammer', marks: 88 }, { subject: 'Accounts', marks: 73 }] },
        { name: 'f4', subjects: [{ subject: 'Grammer', marks: 95 }, { subject: 'Accounts', marks: 94 }] },
        { name: 'g4', subjects: [{ subject: 'Grammer', marks: 63 }, { subject: 'Accounts', marks: 90 }] },
        { name: 'h4', subjects: [{ subject: 'Grammer', marks: 80 }, { subject: 'Accounts', marks: 89 }] },
        { name: 'i4', subjects: [{ subject: 'Grammer', marks: 85 }, { subject: 'Accounts', marks: 98 }] },
        { name: 'j4', subjects: [{ subject: 'Grammer', marks: 50 }, { subject: 'Physics', marks: 80 }] },
        { name: 'k4', subjects: [{ subject: 'Grammer', marks: 60 }, { subject: 'Physics', marks: 69 }] },
        { name: 'l4', subjects: [{ subject: 'Grammer', marks: 98 }, { subject: 'Physics', marks: 93 }] },
        { name: 'm4', subjects: [{ subject: 'Grammer', marks: 85 }, { subject: 'Physics', marks: 74 }] },
        { name: 'n4', subjects: [{ subject: 'Grammer', marks: 100 }, { subject: 'Physics', marks: 98 }] },
        { name: 'o4', subjects: [{ subject: 'Grammer', marks: 56 }, { subject: 'Physics', marks: 98 }] },
        { name: 'p4', subjects: [{ subject: 'Grammer', marks: 100 }, { subject: 'Physics', marks: 79 }] },
        { name: 'q4', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Physics', marks: 69 }] },
        { name: 'r4', subjects: [{ subject: 'Grammer', marks: 78 }, { subject: 'Physics', marks: 53 }] },
        { name: 's4', subjects: [{ subject: 'Grammer', marks: 83 }, { subject: 'Physics', marks: 44 }] },
        { name: 't4', subjects: [{ subject: 'Grammer', marks: 67 }, { subject: 'Physics', marks: 86 }] }
    ];

    /* eslint-enable max-len */
    let i = 1;
    const card = () =>
        studentsList.reduce((obj, pos) => {
            let resultPercentage = pos.subjects.reduce(() => {
                return (pos.subjects[0].marks + pos.subjects[1].marks) / pos.subjects.length;
            }, {});
            /* eslint-disable */
            console.log(`${i}  => ` + `{ 'name': ${pos.name}, 'percentage': ${resultPercentage} }`);
            /* eslint-enable */
            i = i + 1;
        }, {});
    const finResult = card(studentsList);
    return finResult;
};
result();
