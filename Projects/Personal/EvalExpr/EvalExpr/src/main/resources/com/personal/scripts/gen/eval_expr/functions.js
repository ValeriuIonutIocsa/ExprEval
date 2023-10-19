function pow(n, order) {
    return Math.pow(n, order);
}

function sqrt(n) {
    return Math.sqrt(n);
}

function ln(n) {
    return Math.log(n);
}

function lg(n) {
    return Math.log(n) / Math.log(10);
}

function log(base, n) {
    return Math.log(n) / Math.log(base);
}

function dec(str) {
    var result;
    if (str.startsWith('0x') || str.startsWith('0X')) {
        result = parseInt(str.slice(2), 16);
    } else if (str.startsWith('0b') || str.startsWith('0B')) {
        result = parseInt(str.slice(2), 2);
    } else {
        result = parseInt(str);
    }
    return result;
}

function hex(n) {
    return '0x' + n.toString(16);
}

function bin(n) {
    return '0b' + n.toString(2);
}
