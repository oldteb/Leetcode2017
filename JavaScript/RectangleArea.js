/**
 * @param {number} A
 * @param {number} B
 * @param {number} C
 * @param {number} D
 * @param {number} E
 * @param {number} F
 * @param {number} G
 * @param {number} H
 * @return {number}
 */
var computeArea = function(A, B, C, D, E, F, G, H) {

    // calculate common area
    let width = A < G && E < C ? Math.min(C,G) - Math.max(A,E) : 0
    let height = F < D && B < H ? Math.min(D,H) - Math.max(B,F) : 0

    let area1 = (C-A)*(D-B)
    let area2 = (G-E)*(H-F)

    return area1 + area2 - width * height
};
