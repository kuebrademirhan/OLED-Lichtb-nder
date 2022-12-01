import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;

public class TogglePublicTest {
	// ========== SYSTEM ==========
	protected static final String EX_NAME_Lights = "Lights";
	protected static final String CLASS_NAME_Light = "Light";
	protected static final String METH_NAME_Toggle = "Toggle";
	protected static final String METH_NAME_Toggle_isOn = "isOn";
	protected static final String METH_NAME_Toggle_mostLeft = "mostLeft";
	protected static final String METH_NAME_Toggle_mostRight = "mostRight";
	protected static final String METH_NAME_Toggle_isRangeOff = "isRangeOff";
	protected static final String METH_NAME_Toggle_isAllOff = "isAllOff";
	protected static final String METH_NAME_Toggle_makeAllOff = "makeAllOff";
	// --------------------

	// ========== PUBLIC TEST ==========
	// -------------------- Intestines --------------------
	@Test(timeout = 555)
	public void pubTest__Toggle__intestines_THIS_TEST_IS_VERY_IMPORTANT_IF_IT_FAILS_THEN_YOU_WILL_GET_NO_POINTS_AT_ALL() {
		Class<Toggle> clazz = Toggle.class;
		assertTrue(clazz + " must be public!", Modifier.isPublic(clazz.getModifiers()));
		assertFalse(clazz + " must not be abstract!", Modifier.isAbstract(clazz.getModifiers()));
		assertFalse(clazz + " must not be an annotation!", clazz.isAnnotation());
		assertFalse(clazz + " must not be an enumeration!", clazz.isEnum());
		assertFalse(clazz + " must not be an interface!", clazz.isInterface());
		assertSame(clazz + " must extend a certain super-class!", Light.class, clazz.getSuperclass());
		assertEquals(clazz + " must implement a certain number of interfaces!", 0, clazz.getInterfaces().length);
		assertEquals(clazz + " must declare a certain number of inner annotations!", 0, clazz.getDeclaredAnnotations().length);
		assertEquals(clazz + " must declare a certain number of inner classes!", 0, getDeclaredClasses(clazz).length);
		Field[] fields = getDeclaredFields(clazz);
		assertEquals(clazz + " must declare a certain number of fields!", 0, fields.length);
		Constructor<?>[] constructors = getDeclaredConstructors(clazz);
		assertEquals(clazz + " must declare a certain number of constructors (possibly including default constructor)!", 1, constructors.length);
		for (Constructor<?> constructor : constructors) {
			assertTrue(constructor + " - constructor must be protected!", Modifier.isProtected(constructor.getModifiers()));
			assertEquals(constructor + " - constructor must have a certain number of parameters!", 2, constructors[0].getParameterTypes().length);
			assertSame(constructor + " - constructor must have parameters of certain types!", Light.class, constructors[0].getParameterTypes()[0]);
			assertSame(constructor + " - constructor must have parameters of certain types!", long.class, constructors[0].getParameterTypes()[1]);
		}
		Method[] methods = getDeclaredMethods(clazz), abstractMethods = getDeclaredMethods(Light.class);
		int numberOfRequiredMethods = 0;
		for (Method abstractMethod : abstractMethods) {
			if (Modifier.isAbstract(abstractMethod.getModifiers())) {
				numberOfRequiredMethods++;
			}
		}
		assertEquals(clazz + " must declare a certain number of methods!", numberOfRequiredMethods, methods.length);
		for (Method method : methods) {
			boolean foundMatchingMethod = false;
			for (Method abstractMethod : abstractMethods) {
				if (method.getName().equals(abstractMethod.getName()) && Modifier.isAbstract(abstractMethod.getModifiers())) {
					foundMatchingMethod = true;
					assertTrue(method + " - method must be public!", Modifier.isPublic(method.getModifiers()));
					assertFalse(method + " - method must not be static!", Modifier.isStatic(method.getModifiers()));
					assertFalse(method + " - method must not be abstract!", Modifier.isAbstract(method.getModifiers()));
					assertSame(method + " - method must have a certain return type!", abstractMethod.getReturnType(), method.getReturnType());
					assertEquals(method + " - method must have a certain number of parameters!", abstractMethod.getParameterTypes().length, method.getParameterTypes().length);
					for (int parameterIdx = 0; parameterIdx < method.getParameterTypes().length; parameterIdx++) {
						assertSame(method + " - method must have parameters of certain types!", abstractMethod.getParameterTypes()[parameterIdx], method.getParameterTypes()[parameterIdx]);
					}
				}
			}
			assertTrue(clazz + " must declare certain methods! Found unexpected method: " + method, foundMatchingMethod);
		}
	}

	// -------------------- Ops and Axs --------------------
	@Test(timeout = 555)
	public void pubTest_smokeTest() {
		Light lightNew = Light.New();
		Light lightNew_makeAllOff = lightNew.makeAllOff();
		Light lightNew_T42 = Light.Toggle(lightNew, 42);
		Light lightNew_T42_T4711 = Light.Toggle(lightNew_T42, 4711);
		Light lightNew_T42_T4711_Tm666_T42_T0_T815 = Light.Toggle(Light.Toggle(Light.Toggle(Light.Toggle(lightNew_T42_T4711, -666), 42), 0), 815);
		Light lightNew_T42_T4711_Tm666_T42_T0_T815_makeAllOff = lightNew_T42_T4711_Tm666_T42_T0_T815.makeAllOff();
		Light l;
		l = lightNew;
		assertTrue(METH_NAME_Toggle_isOn + " (on new " + CLASS_NAME_Light + ")", !l.isOn(40) & !l.isOn(41) & !l.isOn(42) & !l.isOn(43) & !l.isOn(44));
		assertEquals(METH_NAME_Toggle_mostLeft + " (on new " + CLASS_NAME_Light + ")", 0, l.mostLeft());
		assertEquals(METH_NAME_Toggle_mostRight + " (on new " + CLASS_NAME_Light + ")", 0, l.mostRight());
		assertTrue(METH_NAME_Toggle_isRangeOff + " (on new " + CLASS_NAME_Light + ")", l.isRangeOff(-4711, 4711));
		assertTrue(METH_NAME_Toggle_isAllOff + " (on new " + CLASS_NAME_Light + ")", l.isAllOff());
		l = lightNew_makeAllOff;
		assertTrue(METH_NAME_Toggle_isOn + " after " + METH_NAME_Toggle_makeAllOff, !l.isOn(40) & !l.isOn(41) & !l.isOn(42) & !l.isOn(43) & !l.isOn(44));
		assertEquals(METH_NAME_Toggle_mostLeft + " after " + METH_NAME_Toggle_makeAllOff, 0, l.mostLeft());
		assertEquals(METH_NAME_Toggle_mostRight + " after " + METH_NAME_Toggle_makeAllOff, 0, l.mostRight());
		assertTrue(METH_NAME_Toggle_isRangeOff + " after " + METH_NAME_Toggle_makeAllOff, l.isRangeOff(-4711, 4711));
		assertTrue(METH_NAME_Toggle_isAllOff + " after " + METH_NAME_Toggle_makeAllOff, l.isAllOff());
		l = lightNew_T42_T4711;
		boolean lightNew_T42_T4711_state_of_isOn = //
				!l.isOn(40) & l.isOn(41) & l.isOn(42) & l.isOn(43) & !l.isOn(44) //
						&& !l.isOn(4709) & l.isOn(4710) & l.isOn(4711) & l.isOn(4712) & !l.isOn(4713);
		assertTrue(METH_NAME_Toggle_isOn + " after 2x" + METH_NAME_Toggle, lightNew_T42_T4711_state_of_isOn);
		assertEquals(METH_NAME_Toggle_mostLeft + " after 2x" + METH_NAME_Toggle, 41, l.mostLeft());
		assertEquals(METH_NAME_Toggle_mostRight + " after 2x" + METH_NAME_Toggle, 4712, l.mostRight());
		assertTrue(METH_NAME_Toggle_isRangeOff + " after 2x" + METH_NAME_Toggle, l.isRangeOff(-4711, 40) && !l.isRangeOff(-4711, 4711) && l.isRangeOff(4713, 6666));
		assertFalse(METH_NAME_Toggle_isAllOff + " after 2x" + METH_NAME_Toggle, l.isAllOff());
		l = lightNew_T42_T4711_Tm666_T42_T0_T815;
		boolean lightNew_T42_T4711_Tm666_T42_T0_T815_state_of_isOn = //
				!l.isOn(-668) & l.isOn(-667) & l.isOn(-666) & l.isOn(-665) & !l.isOn(-664) //
						&& !l.isOn(-2) & l.isOn(-1) & l.isOn(0) & l.isOn(1) & !l.isOn(2) //
						&& !l.isOn(40) & !l.isOn(41) & !l.isOn(42) & !l.isOn(43) & !l.isOn(44) //
						&& !l.isOn(813) & l.isOn(814) & l.isOn(815) & l.isOn(816) & !l.isOn(817) //
						&& !l.isOn(4709) & l.isOn(4710) & l.isOn(4711) & l.isOn(4712) & !l.isOn(4713);
		assertTrue(METH_NAME_Toggle_isOn + " after 4x" + METH_NAME_Toggle, lightNew_T42_T4711_Tm666_T42_T0_T815_state_of_isOn);
		assertEquals(METH_NAME_Toggle_mostLeft + " after 4x" + METH_NAME_Toggle, -667, l.mostLeft());
		assertEquals(METH_NAME_Toggle_mostRight + " after 4x" + METH_NAME_Toggle, 4712, l.mostRight());
		assertTrue(METH_NAME_Toggle_isRangeOff + " after 4x" + METH_NAME_Toggle, l.isRangeOff(-4711, -668) && !l.isRangeOff(-4711, 4711) && l.isRangeOff(4713, 6666));
		assertFalse(METH_NAME_Toggle_isAllOff + " after 4x" + METH_NAME_Toggle, l.isAllOff());
		l = lightNew_T42_T4711_Tm666_T42_T0_T815_makeAllOff;
		boolean lightNew_T42_T4711_Tm666_T42_T0_T815_makeAllOff_state_of_isOn = false;
		for (long p = -700; p < 5000; p++) {
			lightNew_T42_T4711_Tm666_T42_T0_T815_makeAllOff_state_of_isOn |= l.isOn(p);
		}
		assertFalse(METH_NAME_Toggle_isOn + " after 4x" + METH_NAME_Toggle + " and " + METH_NAME_Toggle_makeAllOff, lightNew_T42_T4711_Tm666_T42_T0_T815_makeAllOff_state_of_isOn);
		assertEquals(METH_NAME_Toggle_mostLeft + " after 4x" + METH_NAME_Toggle + " and " + METH_NAME_Toggle_makeAllOff, -667, l.mostLeft());
		assertEquals(METH_NAME_Toggle_mostRight + " after 4x" + METH_NAME_Toggle + " and " + METH_NAME_Toggle_makeAllOff, 4712, l.mostRight());
		assertTrue(METH_NAME_Toggle_isRangeOff + " after 4x" + METH_NAME_Toggle + " and " + METH_NAME_Toggle_makeAllOff, l.isRangeOff(-4711, -668) && l.isRangeOff(-4711, 4711) && l.isRangeOff(4713, 6666));
		assertTrue(METH_NAME_Toggle_isAllOff + " after 4x" + METH_NAME_Toggle + " and " + METH_NAME_Toggle_makeAllOff, l.isAllOff());
		l = lightNew_T42;
		assertTrue(METH_NAME_Toggle_isOn + " after 1x" + METH_NAME_Toggle, !l.isOn(40) & l.isOn(41) & l.isOn(42) & l.isOn(43) && !l.isOn(44));
		assertEquals(METH_NAME_Toggle_mostLeft + " after 1x" + METH_NAME_Toggle, 41, l.mostLeft());
		assertEquals(METH_NAME_Toggle_mostRight + " after 1x" + METH_NAME_Toggle, 43, l.mostRight());
		assertTrue(METH_NAME_Toggle_isRangeOff + " after 1x" + METH_NAME_Toggle, l.isRangeOff(-4711, 40) && !l.isRangeOff(-4711, 4711) && l.isRangeOff(44, 4711));
		assertFalse(METH_NAME_Toggle_isAllOff + " after 1x" + METH_NAME_Toggle, l.isAllOff());
	}

	// ========== HELPER: Intestines ==========
	// @AuD-STUDENT: DO NOT USE REFLECTION IN YOUR OWN SUBMISSION!
	private static Class<?>[] getDeclaredClasses(Class<?> clazz) {
		java.util.List<Class<?>> declaredClasses = new java.util.ArrayList<>();
		for (Class<?> c : clazz.getDeclaredClasses()) {
			if (!c.isSynthetic()) {
				declaredClasses.add(c);
			}
		}
		return declaredClasses.toArray(new Class[0]);
	}

	private static Field[] getDeclaredFields(Class<?> clazz) {
		java.util.List<Field> declaredFields = new java.util.ArrayList<>();
		for (Field f : clazz.getDeclaredFields()) {
			if (!f.isSynthetic()) {
				declaredFields.add(f);
			}
		}
		return declaredFields.toArray(new Field[0]);
	}

	private static Constructor<?>[] getDeclaredConstructors(Class<?> clazz) {
		java.util.List<Constructor<?>> declaredConstructors = new java.util.ArrayList<>();
		for (Constructor<?> c : clazz.getDeclaredConstructors()) {
			if (!c.isSynthetic()) {
				declaredConstructors.add(c);
			}
		}
		return declaredConstructors.toArray(new Constructor[0]);
	}

	private static Method[] getDeclaredMethods(Class<?> clazz) {
		java.util.List<Method> declaredMethods = new java.util.ArrayList<>();
		for (Method m : clazz.getDeclaredMethods()) {
			if (!m.isBridge() && !m.isSynthetic()) {
				declaredMethods.add(m);
			}
		}
		return declaredMethods.toArray(new Method[0]);
	}
}