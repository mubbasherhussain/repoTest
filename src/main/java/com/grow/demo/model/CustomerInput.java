package com.grow.demo.model;

public class CustomerInput {
		private double input1 = 0.0;
		private double input2 = 0.0;
		public double getInput1() {
			return input1;
		}
		public void setInput1(double input1) {
			this.input1 = input1;
		}
		public double getInput2() {
			return input2;
		}
		public void setInput2(double input2) {
			this.input2 = input2;
		}
		@Override
		public String toString() {
			return "Customer [input1=" + input1 + ", input2=" + input2 + "]";
		}
}
