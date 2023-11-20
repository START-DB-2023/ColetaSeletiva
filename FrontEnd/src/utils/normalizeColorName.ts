export function normalizeColorName(color: string) {
  return color.charAt(0) + color.slice(1).toLowerCase();
}
