import chai  from 'chai';
import addition from "../../app/kata/sample.js";

describe("An addition shoud", function() {
    it ("give the sum of 2 integers", function() {
        chai.expect(addition(1,1)).to.equal(2)
    })
});